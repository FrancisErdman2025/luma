# Luma Test Automation

## Overview
This project automates test cases for the 'Add to Cart' functionality on the Luma eCommerce site using Selenium, Java 17, and TestNG, following the Page Object Model (POM) design pattern.

## Prerequisites
- Java 17
- Maven
- Eclipse (or any preferred IDE supporting Maven)

## Setup Instructions
1. Clone the repository.
2. Open the project in Eclipse.
3. Run `mvn clean install` to resolve dependencies.
4. Execute tests by right-clicking `LumaTest.java` and selecting `Run as TestNG Test`.

## ChromeDriver Information
No need to manually download or configure ChromeDriver. The project uses WebDriverManager, which:
- Automatically downloads the correct version of ChromeDriver.
- Configures the system path for seamless execution.
- Ensures compatibility with the installed Chrome browser version.

## Future Considerations
- Expand test coverage to include additional user workflows.
- Implement parallel test execution with TestNG for efficiency.
- Enhance reporting for better test insights.

## Contact
For any issues, please open a GitHub issue or reach out to FrancisErdman@mailfence.com.
