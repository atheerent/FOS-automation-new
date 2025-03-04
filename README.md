# Atheer project - Automation testing
The Atheer repository project is for test automation, smoke/regression testing, and automation scripting.

## What is it used for and why do we require it?
This repository demonstrates how to utilise automation tools and scripts to perform software testing in the Pronto application.- Faster test execution compared to manual test
- Repeatability
- Smoke testing
- Mavenised tests

## Tech Stack used
- Selenium - Browser automation framework
- Maven - Dependency management
- Cucumber - Behavior Driven Development tool
- Junit - Testing framework
- TestNG - Testing framework
- Extent report - Reporting framework
- WebDriverManager - Local driver binary management
- AWS S3 - To import and upload files

## Features covered in code
- Automation script for testing
- Smoke tests
- Module wise functionalities testing

## How to Install and setup in local ?
- Install latest JAVA JRE from https://www.java.com/en/download/
- Install an IDE-code editor

## Deployment process
- Clone repository
- Open repository in IDE

## How to run tests in local using this code ?
- Enter valid credentials in config file. (located at - src/test/java/resources/configuration/config.properties)
- Open testRunner file. (located at - src/test/java/runner/testRunner.java) and change features value to "./src/test/java/features/core/"
- Enter a tag value (anyone) : @all or @{{specific module name}} or @smoke
- Right click on Project and select MAVEN and reload the project. (It will download the dependencies necessary for the project's operation)
- Run the testRunner file to perform the test scenarios.

## Reporting - Automation Test report
- After the test scenarios have run, open the root folder containing the name - test-output.
- Expand folders and go to Spark-reports.
- Open spark-report.html in your browser to view the automation report that was generated based on the most recent execution.

## Contributing
Contributions are always welcome!
- Writing tests
- Code review
- Other guidelines
