Feature: The user should be able to place order from web page

  Background:
    Given The user navigates to website

  Scenario: Placing a successfully order
    When The user clicks on login button and enters "Edel" and "Test1234"
    And The user adds "Samsung galaxy s7" product from "Phones" category
    And The user adds "Sony vaio i5" product from "Laptops" category
    And The user adds "MacBook Pro" product from "Laptops" category
    And The user adds "Apple monitor 24" product from "Monitors" category
    And The user removes "Sony vaio i5" chosen product from Cart page
    And The user places order and capture and log amount
    Then The user verifies purchase amount











