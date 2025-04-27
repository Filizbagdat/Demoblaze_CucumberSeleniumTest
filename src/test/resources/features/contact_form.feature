Feature: Contact Form Submission

  Background:
    Given The user navigates to website

  Scenario: User submits a contact form
    When The user clicks login button and enters valid credentials
    Then The user verifies welcome message
    When User is on the contact page
    Then The user verifies message

