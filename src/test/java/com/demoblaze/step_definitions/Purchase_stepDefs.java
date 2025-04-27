package com.demoblaze.step_definitions;

import com.demoblaze.pages.CartPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Purchase_stepDefs {
    CartPage cartPage=new CartPage();
    int expectedPurchaseAmount=0;
    @When("The user adds {string} product from {string} category")
    public void the_user_adds_product_from_category(String product, String category) {
        expectedPurchaseAmount+=cartPage.addProduct(product, category);
    }
    @When("The user removes {string} chosen product from Cart page")
    public void the_user_removes_chosen_product_from_cart_page(String removeProduct) {
        expectedPurchaseAmount-= cartPage.removeProduct(removeProduct);
    }
    @When("The user places order and capture and log amount")
    public void the_user_places_order_and_capture_and_log_amount() {
        cartPage.finishPurchase_logAmount();
    }
    @Then("The user verifies purchase amount")
    public void the_user_verifies_purchase_amount() {
        cartPage.verifyPurchaseAmount(expectedPurchaseAmount);
    }
}