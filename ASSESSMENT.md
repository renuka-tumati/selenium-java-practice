# Selenium + Java Debugging Assessment

**Level:** Intermediate–advanced | **Time:** 75 minutes | **Score:** 100 points

## Scenario
You have joined the QA automation team for Acme's order portal. The repository contains a partially implemented Page Object Model and four tests. CI reports intermittent and consistent failures. Your assignment is to investigate the actual behavior, repair test-side issues, and add coverage. **Do not change `app/index.html`**; treat it as the product under test.

## Part A — Diagnose and repair (30 points; 25 minutes)
1. Execute the full test suite. Record each failure and its exception/assertion details.
2. Distinguish synchronization problems from incorrect expectations and locator/interaction failures.
3. Repair the tests/framework so that the four existing tests reliably pass, without weakening assertions or using unconditional `Thread.sleep`.
4. Write a brief root-cause explanation for each defect in `FINDINGS.md`.

## Part B — Synchronization and maintainability (20 points; 15 minutes)
1. Centralize explicit-wait handling appropriately (no global implicit wait).
2. Ensure page objects do not rely on timing assumptions.
3. Avoid brittle CSS/XPath selectors where stable IDs are available.
4. Keep tests isolated; don't depend on test execution order.

## Part C — Add tests (25 points; 20 minutes)
Implement all of the following using the existing architecture:
1. Invalid password prevents dashboard access and displays an error.
2. Submitting an order with no product shows the correct validation message.
3. Quantity zero is rejected; verify the error message.
4. Quantity eleven is rejected; verify the error message.
5. Successful logout returns to the sign-in form.

## Part D — Engineering judgment (15 points; 10 minutes)
1. Add a JUnit parameterized test for quantity boundaries **or** a reusable data-driven test approach; justify your choice.
2. Improve diagnostic output on failures (e.g., screenshots or helpful assertion messages).
3. Explain one risk of testing against a local `file://` app compared with a real deployed web application.

## Part E — Verbal review (10 points; 5 minutes)
Prepare concise answers:
- Why can `findElement()` succeed while a subsequent interaction fails?
- Why is an element's presence different from visibility or clickability?
- What makes a test flaky versus deterministically wrong?
- How would you execute this suite in parallel in CI?

## Constraints
- Java 17+, Maven 3.9+, Chrome installed.
- Selenium 4 and JUnit 5.
- Do not edit the application.
- Do not remove existing tests, skip tests, or reduce assertion strength.
- No fixed sleeps.
- You may add classes and dependencies as appropriate.

## Submission
A passing `mvn test` run, modified source files, and `FINDINGS.md` containing root causes, fixes, and remaining risks.

## Evaluation rubric
- Root cause identification: 30
- Synchronization and framework quality: 20
- New scenario coverage: 25
- Maintainability/diagnostics: 15
- Explanation: 10

**Note:** The starter code intentionally contains test-side defects. Not all failures have the same cause. No answer key is included.
