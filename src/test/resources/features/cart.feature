Feature: Add to Cart Functionality

  Background:
    Given The user navigates to website

  Scenario: User adds a product to the cart
    When The user clicks login button and enters valid credentials
    Then The user verifies welcome message
    When The user selects "Samsung galaxy s6" from home page
    And The user adds the product to the cart
    Then The user verifies the product is added to cart
