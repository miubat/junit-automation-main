
## Overview
This JUnit WebDriver project automates the web form submission on [Digital Unite Practice Webform](https://www.digitalunite.com/practice-webform-learners). The test uploads a file with a 2MB limit, submits the form, and asserts the success message.
## Prerequisites
- Java
- ChromeDriver
## Getting Started
1. **Clone the repository:**

    ```bash
    git clone https://github.com/miubat/junit-automation-main
    ```

2. **Set the path to your ChromeDriver executable in `FormSubmissionTest.java`.**

3. **Run the tests:**

    ```bash
    ./gradlew clean test
    ```

## Test Execution

The test performs the following steps:

1. Fill in the form fields.
2. Upload a file.
3. Submit the form.
4. Asserts the success message.

## Test Report
![screencapture-file-D-test-automation-JunitAssignment-build-reports-tests-test-index-html-2024-02-28-13_59_29](https://github.com/iamsafridi/junit-digitalunit-automation/assets/82276738/0d5f1e7b-83f8-4cdf-8860-34df27c6bbe9)


