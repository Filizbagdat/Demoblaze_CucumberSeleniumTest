Feature: Logout Test

  Background:
    Given The user navigates to website

  Scenario:  logout test
    When The user clicks login button and enters valid credentials
    Then The user verifies welcome message
    And The user clicks logout button
    Then The user logs out



  Scenario: Logout button should not be visible without login
    Then The user should not see the logout button