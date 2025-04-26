Feature: Logout button visibility when not logged in

  Background:
    Given The user navigates to website

  Scenario: Logout button should not be visible without login
    Then The user should not see the logout button