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

    HomePage homePage = new HomePage();
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
    @When("User clicks on the Phones category")
    public void user_clicks_on_the_phones_category() {
        homePage.phonesCategory.click();
    }
    @Then("User verifies that phones are displayed")
    public void user_verifies_that_phones_are_displayed() {
        homePage.verifyProduct1();
    }
    @When("User clicks on the Laptops category")
    public void user_clicks_on_the_laptops_category() {
        homePage.laptopsCategory.click();
    }
    @Then("User verifies that laptops are displayed")
    public void user_verifies_that_laptops_are_displayed() {
       homePage.verifyProduct2();
    }
    @When("User clicks on the Monitors category")
    public void user_clicks_on_the_monitors_category() {
        homePage.monitorsCategory.click();
    }
    @Then("User verifies that monitors are displayed")
    public void user_verifies_that_monitors_are_displayed() {
      homePage.verifyProduct3();
    }
    @Then("User verifies that product details page is displayed")
    public void user_verifies_that_product_details_page_is_displayed() {
        BrowserUtils.waitFor(2);
        Assert.assertTrue("Product name is not displayed!", productPage.productName.isDisplayed());
    }
}












