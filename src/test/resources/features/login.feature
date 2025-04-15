
Feature: Login Test
  Background:
    Given The user navigates to website

  Scenario: positive login test 1 without parameter
    When The user clicks login button and enters valid credentials
    Then The user verifies welcome message

  Scenario: positive login test 2 without parameter
    When The user clicks on login button and enters "Filiz" and "Filiz11."
    When The user verifies welcome message contains "Filiz"

  Scenario Outline: positive login test 3 with scenario outline
    When The user clicks on login button and enters "<username>" and "<password>"
    Then The user verifies welcome message contains "<username>"
    Examples:
      | username | password |
      | Filiz    | Filiz11. |

  Scenario Outline: positive login test 4 with scenario outline and data table
    When The user clicks on login button and enters following credentials
      | user_name     | <username> |
      | user_password | <password> |
    Then The user verifies welcome message contains "<username>"
    Examples:
      | username | password |
      | Filiz    | Filiz11. |

  Scenario Outline: Negative Login Test 5
    When The user clicks on login button and enters "<invalid_username>" and "<invalid_password>"
    Then The user verifies invalid access message is "<message>"
    Examples:
      | invalid_username | invalid_password | message                                |
      | Filizz           | Filiz11.         | User does not exist.                   |
      | Filizz           | Filiz11..        | User does not exist.                   |
      | Filiz            | Filiz11..        | Wrong password.                        |
      |                  | Filiz11.         | Please fill out Username and Password. |
      | Filiz            |                  | Please fill out Username and Password. |
      |                  |                  | Please fill out Username and Password. |