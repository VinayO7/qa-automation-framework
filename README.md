# Hybrid Automation Framework

A scalable Selenium Test Automation Framework built using Java, Selenium WebDriver, TestNG, Maven, Page Object Model (POM), Extent Reports, and JSON-based test data management.

## Features

* Selenium WebDriver Automation
* Java + Maven Project Structure
* Page Object Model (POM)
* Explicit Wait Utilities
* TestNG Test Execution
* JSON Test Data Support
* Extent Reports
* Screenshot Capture on Failure
* TestNG Listeners
* Configurable Test Environment
* Reusable BasePage and BaseTest Architecture

---

## Tech Stack

| Technology         | Purpose                  |
| ------------------ | ------------------------ |
| Java               | Programming Language     |
| Selenium WebDriver | UI Automation            |
| TestNG             | Test Execution Framework |
| Maven              | Dependency Management    |
| Jackson            | JSON Data Handling       |
| Extent Reports     | Reporting                |
| Git & GitHub       | Version Control          |

---

## Project Structure

```text
src
├── main
│   ├── java
│   │   ├── core
│   │   │   ├── config
│   │   │   ├── reports
│   │   │   └── utils
│   │   │
│   │   └── ui
│   │       ├── drivers
│   │       └── pages
│   │
│   └── resources
│       └── config.properties
│
└── test
    ├── java
    │   ├── core
    │   │   └── listeners
    │   │
    │   └── ui
    │       ├── base
    │       └── tests
    │
    └── resources
        └── testdata
```

---

## Implemented Test Scenarios

### Login Validation

* Verify successful login
* Verify dashboard visibility after login

### Add Employee

* Navigate to PIM module
* Create a new employee
* Save employee record

### Personal Details Update

* Update Driver's License Number
* Update License Expiry Date
* Update Date of Birth
* Select Nationality
* Select Marital Status
* Select Gender
* Save Employee Details

---

## Reporting

### Extent Reports

Execution report is generated at:

```text
test-output/ExtentReport.html
```

### Screenshots

Failure screenshots are automatically captured and stored under:

```text
test-output/screenshots
```

---

## Test Data Management

Employee test data is maintained using JSON files.

Example:

```json
{
  "licenseNumber": "123456789",
  "licenseExpiryDate": "2032-01-06",
  "dateOfBirth": "2024-08-24",
  "nationality": "Indian",
  "maritalStatus": "Single"
}
```

---

## Design Patterns Used

* Page Object Model (POM)
* Factory Pattern (DriverFactory)
* Singleton Pattern (ExtentManager)
* Utility Pattern (WaitUtil, ScreenshotUtil, JsonUtil)

---

## Future Enhancements

* Log4j2 Logging
* Data Providers
* Parallel Execution
* Cross Browser Execution
* API Automation Framework Integration
* CI/CD Pipeline Integration
* Docker Execution Support

---

## Author

Vinay Nalavade

LinkedIn:
https://www.linkedin.com/in/vinaynalavade/

GitHub:
https://github.com/
