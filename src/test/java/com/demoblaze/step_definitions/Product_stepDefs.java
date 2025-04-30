package com.demoblaze.step_definitions;

import com.demoblaze.pages.CartPage;
import com.demoblaze.pages.HomePage;
import com.demoblaze.pages.ProductPage;
import com.demoblaze.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Product_stepDefs {

    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();

    @When("User clicks on a product")
    public void user_clicks_on_a_product() {
        BrowserUtils.waitFor(4);
        cartPage.firstProduct.click();
        BrowserUtils.waitFor(4);
    }
    @And("User notes the product price")
    public void user_notes_the_product_price() {
        productPage.getprice();
    }
    @And("User adds the product to the cart")
    public void user_adds_the_product_to_the_cart() {
        BrowserUtils.waitFor(2);
        productPage.addToCartButton.click();
        BrowserUtils.waitFor(5);
        BrowserUtils.waitForAlertAndAccept();
    }
    @And("User navigates to the cart page")
    public void user_navigates_to_the_cart_page() {
        BrowserUtils.waitFor(3);
        cartPage.cartButton.click();
        BrowserUtils.waitFor(3);
    }
    @Then("The product price in the cart should match the product page price")
    public void the_product_price_in_the_cart_should_match_the_product_page_price() {
        productPage.priceControl();
    }
    @Then("User verifies that product details page is displayed")
    public void user_verifies_that_product_details_page_is_displayed() {
        BrowserUtils.waitFor(2);
        Assert.assertTrue("Product name is not displayed!", productPage.productName.isDisplayed());
    }
    @When("the user clicks on the {string} category")
    public void the_user_clicks_on_the_category(String category) {
        productPage.clickCategory(category);
    }
    @Then("the user should see products in the {string} category")
    public void the_user_should_see_products_in_the_category(String category) {
        Assert.assertTrue(productPage.isCategoryDisplayed(category));
    }
}












