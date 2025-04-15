Feature: Logout Test

  Background:
    Given The user navigates to website

  Scenario:  logout test
    When The user clicks login button and enters valid credentials
    Then The user verifies welcome message
    And The user clicks logout button
    Then The user logs out
