# Test Automation Portfolio

A showcase of my test automation skills using **Selenium WebDriver, Java, TestNG**, and **Maven**.

---

## 📋 Project Overview

This project demonstrates a scalable and maintainable test automation framework with:

- Page Object Model (POM) design pattern
- Utility classes for WebDriver management
- TestNG for assertions and execution
- Maven for dependency and build management

---

## 🧪 Test Scenarios

### 1. **Login Functionality**
- Successful login with valid credentials
- Error handling with invalid credentials
- Error handling with valid username but invalid password

### 2. **Locator Practice**
- ID, CSS, Name locator tests using:
  - [https://demoqa.com](https://demoqa.com) (where applicable)
  - [https://openlibrary.org](https://openlibrary.org) (where applicable)
  - [https://techlistic.com](https://techlistic.com) (where applicable)

### 3. **Custom Poetic Exercise**
- A fun test inspired by my poetic interests (`MaryBeAPoetTest.java`) using my website https://www.marybeapoet.com/

---

## 🧱 Project Structure

temp-portfolio/
├── src/
│   ├── main/
│   │   └── resources/
│   └── test/
│       ├── java/
│       │   ├── ctrl.alt.del.g1thub.tests/
│       │   │   ├── LoginTest.java
│       │   │   └── MaryBeAPoetTest.java
│       │   ├── github.ctrlaltdel.selenium.openlibrary/
│       │   │   └── OpenLibrarySearchTest.java
│       │   └── locators/
│       │       ├── ClassNameLocators.java
│       │       ├── ClassNameTests.java
│       │       ├── CssSelectorLocators.java
│       │       ├── CssSelectorTests.java
│       │       ├── IDLocators.java
│       │       └── IDTests.java
│       │       ├── LinkTextLocators.java
│       │       └── LinkTextTests.java
│       │       ├── NameLocators.java
│       │       └── NameTests.java
│       │       ├── PartialLinkTextLocators.java
│       │       └── PartialLinkTextTests.java
│       │       ├── TagNameLocators.java
│       │       └── TagNameTests.java
│       │       ├── XPathLocators.java
│       │       └── XPathTests.java



│       └── resources/
├── Drivers/
│   └── chromedriver.exe
├── pom.xml
├── testng.xml
└── README.md

---

## 🛠 Technical Stack

- Java 11+
- Selenium WebDriver 4.x
- TestNG 7.x
- Maven 3.x
- ChromeDriver (manually placed under `Drivers/`)

---

## ▶️ How to Run Tests

### Prerequisites
- Java JDK 11+
- Maven installed
- Chrome browser

### Steps
1. Clone this repo
2. Import into Eclipse/IntelliJ
3. Run with TestNG or from command line:
```bash
mvn clean test

###🧩 Notes on Locators
Some ID-based exercises use demoqa.com instead of Open Library due to missing or dynamic IDs. Name based exercises use techlistic.com instead of Open Library due to lack of name locators.

Exercises like IDTests.java and CssSelectorTests.java include examples of working with tables, buttons, and headers.

📌 Future Enhancements
Additional test scenarios for different websites
API testing examples
Performance testing samples



📫 Contact
Feel free to reach out to me at mbg.job.mail@gmail.com for collaboration or questions.
>>>>>>> branch 'master' of https://github.com/ctrl-alt-del-G1tHub/selenium-java-portfolio





