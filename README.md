# Selenium Java QA Interview — Starter Project

This is a standalone, intentionally failing Selenium + Java exercise.

## Prerequisites
- JDK 17 or later (`java -version`)
- Maven 3.9+ (`mvn -version`)
- Google Chrome installed
- Internet access on first run to download Maven dependencies and, if needed, a ChromeDriver via Selenium Manager

## Run
```bash
mvn test
```
For headless execution:
```bash
mvn test -Pheadless
```
On Windows PowerShell, run the same Maven commands from the extracted project root. If Chrome is not discoverable, configure `ChromeOptions#setBinary` with its installed path.

Test results and stack traces: `target/surefire-reports/`.

## GitHub Codespaces
Codespaces runs Linux without a desktop, so use the headless profile. Chrome also requires system libraries that may not be installed in the container. On Ubuntu 24.04 (Noble), install them with:
```bash
sudo apt-get update
sudo apt-get install -y libatk1.0-0 libatk-bridge2.0-0 libcups2 libxkbcommon0 libasound2t64 libgbm1 libxcomposite1 libxdamage1 libxfixes3 libxrandr2 libatspi2.0-0
```
Then run the tests:
```bash
mvn -Pheadless test
```
To check whether Chrome still has missing shared libraries:
```bash
CHROME=$(find ~/.cache/selenium/chrome -type f -name chrome -print -quit)
ldd "$CHROME" | grep "not found"
```
No output from the `ldd` command means it found no missing shared libraries.

## Your assignment
Read [ASSESSMENT.md](ASSESSMENT.md). Start a 75-minute timer before executing tests. The web app is loaded from a local `file://` URL, so no application server is required.

## Layout
- `app/index.html`: application under test — do not edit
- `src/test/java/com/interview/core/`: test setup/teardown
- `src/test/java/com/interview/pages/`: page objects
- `src/test/java/com/interview/tests/`: existing tests
- `ASSESSMENT.md`: tasks and scoring

Credentials are intentionally provided for the exercise: `qa_user` / `Passw0rd!`.

No answer key is provided in this starter project.
