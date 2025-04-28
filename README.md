# Demoblaze Automation Testing with Selenium & Cucumber

This project is a test automation framework built using Selenium WebDriver, Cucumber (BDD), and Java/Maven, created to automate testing for key functionalities of the Demoblaze website.

📌 Features Tested

🔐 Login Functionality

🛒 Product Purchase Flow

🚪 Logout Functionality

🛍️ Product Page

🛒 Cart Page

📝 Sign-Up Page Functionality

📞 Contact Page Functionality

🛠️ Tech Stack

Java

Selenium WebDriver

Cucumber (BDD)

Maven

JUnit

Page Object Model (POM) Design Pattern

📁 Project Structure

src
├── main
│   └── java
│       └── com.demoblaze
│           ├── runners
│           │   └── CukesRunner.java
│           ├── step_definitions
│           │   ├── Hooks.java
│           │   ├── Login_stepDefs.java
│           │   ├── Logout_stepDefs.java 
│           │   ├── Purchase_stepDefs.java
│           │   ├── ProductPage_stepDefs.java
│           │   ├── CartPage_stepDefs.java
│           │   ├── SignUp_stepDefs.java  
│           │   └── ContactPage_stepDefs.java  
│           └── utilities
│               ├── BrowserUtils.java
│               ├── ConfigurationReader.java
│               └── Driver.java
└── resources
└── features
├── login.feature
├── purchase.feature
├── productPage.feature
├── cartPage.feature
├── signUp.feature  
├── logout.feature  
└── contact.feature 

🚀 How to Run Tests

Clone the repository:
git clone https://github.com/Filizbagdat/Demoblaze_CucumberSeleniumTest

Navigate to the project directory:
cd Demoblaze_CucumberSeleniumTest

Run the tests using Maven:
mvn test

🔧 Configuration

Ensure Java and Maven are installed on your machine.

Configure Driver.java for browser settings (e.g., ChromeDriver).

Update ConfigurationReader.java for environment-specific configurations (e.g., base URL, credentials).

📝 Notes

The framework uses Cucumber for behavior-driven development (BDD), where feature files describe the behavior in natural language.

The Page Object Model (POM) design pattern is employed for better maintainability of tests.

Tests are run using JUnit.