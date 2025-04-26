Feature: Contact Form Submission
  Background:
    Given The user navigates to website

  Scenario: User submits a contact form
    When The user clicks login button and enters valid credentials
    Then The user verifies welcome message
    When User is on the contact page
    Then The user verifies message

  Scenario: Contact form submission without email
    When The user clicks on Contact menu
    And The user fills contact form with name "Ahmet", empty email and message "Test message"
    And The user clicks Send Message
    Then The user should see an alert "Please fill out Email and Message."
