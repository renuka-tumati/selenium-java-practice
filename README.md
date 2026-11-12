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
