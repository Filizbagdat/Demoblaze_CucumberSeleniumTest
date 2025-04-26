Feature: User signup process

  Background:
    Given The user navigates to website

  Scenario: User signs up with valid credentials
    When The user clicks on Sign up button
    And The user enters a unique username and password
    And The user confirms sign up
    Then The user should see successful signup alert

  Scenario: User signs up with existing credentials
    When The user clicks on Sign up button
    And The user enters username "Edel" and password "Test1234"
    And The user clicks Sign up to submit
    Then The user should see an alert saying "This user already exist."