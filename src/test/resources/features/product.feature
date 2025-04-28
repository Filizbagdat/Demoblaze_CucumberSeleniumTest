Feature: Verify Product Price in Cart

  Background:
    Given The user navigates to website

  Scenario: User adds a product to the cart and verifies the price
    When User clicks on a product
    And User notes the product price
    And User adds the product to the cart
    And User navigates to the cart page
    Then The product price in the cart should match the product page price

  Scenario Outline: User navigates between different categories

    When the user clicks on the "<category>" category
    Then the user should see products in the "<category>" category
    Examples:
      | category    |
      | Laptops     |
      | Phones      |
      | Monitors    |

  Scenario: User clicks on a product and sees the details page
    When User clicks on a product
    Then User verifies that product details page is displayed
