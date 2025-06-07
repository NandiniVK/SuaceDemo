# Overview

This is a Java-based test automation framework for testing the e-commerce demo site [https://www.saucedemo.com](https://www.saucedemo.com) using:

- Selenium WebDriver
- Cucumber (BDD)
- JUnit
- Maven
- Page Object Model (POM)
- ExtentReports and Cucumber reports for reporting

## Prerequisites

- Java 17 or above
- Maven 3.6+
- Chrome browser
- IDE like IntelliJ or Eclipse

## How to Run the Tests

### Using Maven

```bash
mvn test
```

### Run a Specific Feature

Update the runner class or use tags:

```bash
mvn test -Dcucumber.filter.tags="@Smoke"
```

## Reports

- Cucumber reports
- ExtentReports

## Tags & Suites

Use tags like `@Smoke`, `@Regression` in feature files to group tests.

## Dependencies

Key dependencies include:

```xml
<dependencies>
  <dependency> <!-- Selenium --> </dependency>
  <dependency> <!-- Cucumber Java --> </dependency>
  <dependency> <!-- Cucumber JUnit --> </dependency>
  <dependency> <!-- WebDriverManager --> </dependency>
  <dependency> <!-- ExtentReports --> </dependency>
</dependencies>
```

## Note

Used incognito option for the browser to avoid password configuration popup which affects the execution flow.

## Contact

For questions or issues, contact: nandinivkb@gmail.com
