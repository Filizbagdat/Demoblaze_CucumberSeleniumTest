package com.demoblaze.step_definitions;

import com.demoblaze.pages.*;
import io.cucumber.java.en.*;

public class Cart_stepDefs {
    HomePage homePage = new HomePage();
    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();

    @When("The user selects {string} from home page")
    public void the_user_selects_from_home_page(String productName) {
        productPage.selectProduct(productName);
    }
    @When("The user adds the product to the cart")
    public void the_user_adds_the_product_to_the_cart() {
        productPage.clickAddToCart();
    }
    @Then("The user verifies the product is added to cart")
    public void the_user_verifies_the_product_is_added_to_cart() {
        homePage.navigateToMenu("Cart");
        cartPage.verifyProductInCart("Samsung galaxy s6");
    }
    @Then("User verifies that the cart is empty after the purchase")
    public void user_verifies_that_the_cart_is_empty_after_the_purchase() {
        cartPage.verifyCartEmpty();
    }
}



