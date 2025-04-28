# Demoblaze Automation Testing with Selenium & Cucumber

This project is a test automation framework built using **Selenium WebDriver**, **Cucumber (BDD)** and **Java/Maven**, 
created to test key functionalities of the [Demoblaze](https://www.demoblaze.com/) website.

## 📌 Features Tested

- 🔐 **Login Functionality**
- 🛒 **Product Purchase Flow**
- 🚪 **Logout Functionality**

## 🛠️ Tech Stack

- **Java**
- **Selenium WebDriver**
- **Cucumber (BDD)**
- **Maven**
- **JUnit** 
- **Page Object Model (POM) Design Pattern**

## 📁 Project Structure

src
├── main
│   └── java
│       └──     
│
├── test
│   └── java
│       └── com.demoblaze
│           ├── runners
│           │   └── CukesRunner.java           
│           │
│           ├── step_definitions
│           │   ├── Hooks.java                 
│           │   ├── Login_stepDefs.java        
│           │   ├── Logout_stepDefs.java      
│           │   └── Purchase_stepDefs.java     
│           │
│           └── utilities
│               ├── BrowserUtils.java          
│               ├── ConfigurationReader.java   
│               └── Driver.java                
│
├── resources
│   └── features
│       ├── login.feature              
│       ├── purchase.feature           
│       └── s_logout.feature           

## 🚀 How to Run Tests

1. **Clone the repository:**
    
   git clone https://github.com/Filizbagdat/Demoblaze_CucumberSeleniumTest

2. **Navigate to the project directory:**

   cd demoblaze-automation

3. **Run the tests using Maven:**
   
   mvn test



Filiz Bagdatli
🔗 GitHub: github.com/Filizbagdat