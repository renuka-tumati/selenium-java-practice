# Candidate Findings

## Test failures observed
- The latest Codespaces run with `mvn -Pheadless test` executed all 4 tests: 3 passed and `createOrderDisplaysConfirmation` failed at its assertion with `expected: <true> but was: <false>`.
- Earlier Codespaces runs could not start Chrome. The ChromeDriver log identified missing Linux shared libraries. After installing the Ubuntu 24.04 packages, `ldd` reported no remaining missing libraries and Chrome sessions started.
- Selenium 4.27 logs a warning that it has no CDP implementation matching Chrome 157. This warning did not prevent the tests from running.

## Root causes and evidence
- Chrome startup failures were caused by missing container libraries, including ATK bridge, CUPS, ALSA, GBM, X11, and AT-SPI libraries. Ubuntu 24.04 provides some packages with `t64` names, such as `libasound2t64`.
- `mvn -Pheadless=true test` is not valid profile syntax: Maven looks for a profile literally named `headless=true`. The profile in `pom.xml` is named `headless`; use `mvn -Pheadless test`.
- The app updates login asynchronously after 900 ms and order confirmation after 650 ms. Selenium needs to wait for the resulting dashboard, login error, order success, or order error before reading or interacting with them.
- The app's order confirmation is `Order #<number> created`, while the test checks for the substring `Order created`. The order number between those words means that assertion cannot match the app's message.

## Fixes applied
- `LoginPage.login()` waits for either the dashboard to become visible or the login error to be populated.
- `OrderPage.createOrder()` waits for either the order success or order error message after submitting.
- `BaseTest` supports the `headless` system property, and the Maven `headless` profile sets it for tests. The setup also logs the local app URL.
- The README now documents the Ubuntu 24.04 dependencies, the correct Codespaces test command, and how to check for missing Chrome libraries.
- The Codespaces container dependencies were installed manually; `ldd` then reported no missing libraries.

## Additional test coverage
- No additional test cases were added. The existing suite ran all 4 tests in the latest Codespaces run; 3 passed.

## Residual risks / CI recommendations
- Update the order confirmation assertion to match the actual message, for example `orders.successText().contains("created")`, then rerun `mvn -Pheadless test`.
- The apt-installed libraries are environment state and may not survive Codespace rebuilds. For repeatable CI, install them through the devcontainer configuration or follow the README's install steps after rebuilding.
- The Chrome 157 CDP warning is non-fatal for the current tests. If tests begin using Chrome DevTools Protocol features, align the Selenium version with the browser's CDP version.
