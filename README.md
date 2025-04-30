`
# Demoblaze Automation Testing with Selenium & Cucumber

This project is a test automation framework built using *Selenium WebDriver, **Cucumber (BDD), and **Java/Maven*, designed to automate key functionalities of the [Demoblaze](https://www.demoblaze.com/) website.

---

## 📌 Features Tested

- 🔐 *Login Functionality*
- 🛒 *Product Purchase Flow*
- 🚪 *Logout Functionality*
- 🛍 *Product Page*
- 🛒 *Cart Page*
- 📝 *Sign-Up Page Functionality*
- 📞 *Contact Page Functionality*

---

## 🛠 Tech Stack

- Java
- Selenium WebDriver
- Cucumber (BDD)
- Maven
- JUnit
- Page Object Model (POM) Design Pattern

---

## 📁 Project Structure

src
├── pages
│   ├── BasePage.java
│   ├── CartPage.java
│   ├── ContactPage.java
│   ├── HomePage.java
│   ├── LoginPage.java
│   ├── LogoutPage.java
│   ├── ProductPage.java
│   └── SignUpPage.java
├── runners
│   └── (Runner classes here)
├── step_definitions
│   ├── Cart_stepDefs.java
│   ├── ContactForm_stepDefs.java
│   ├── Hooks.java
│   ├── Login_stepDefs.java
│   ├── Logout_stepDefs.java
│   ├── Product_stepDefs.java
│   ├── Purchase_stepDefs.java
│   └── SignUp_stepDefs.java
└── utilities
└── (Reusable utility classes)


resources
└── features
├── cart.feature
├── contact_form.feature
├── login.feature
├── logout.feature
├── product.feature
├── purchase.feature
└── sign_up.feature

---

## 🚀 How to Run Tests

1. *Clone the repository*:
   bash
   git clone https://github.com/Filizbagdat/Demoblaze_CucumberSeleniumTest


2. *Navigate to the project directory*:
   bash
   cd Demoblaze_CucumberSeleniumTest


3. *Run the tests using Maven*:
   bash
   mvn test


---

## 🔧 Configuration

- Ensure *Java* and *Maven* are installed on your machine.
- Configure Driver.java for browser settings (e.g., ChromeDriver).
- Update ConfigurationReader.java for environment-specific configurations such as *base URL* and *user credentials*.

---

## 📝 Notes

- The framework follows *Behavior-Driven Development (BDD)* principles, using Cucumber feature files to describe behavior in plain English.
- The *Page Object Model (POM)* design pattern is applied for better maintainability and scalability.
- *JUnit* is used as the test runner for executing scenarios.

---

## 👤 Author

*Filiz Bagdatli*  
🔗 [LinkedIn](https://www.linkedin.com/in/filizbagdatli/) 

---

`