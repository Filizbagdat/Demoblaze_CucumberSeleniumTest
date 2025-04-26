package com.demoblaze.step_definitions;

import com.demoblaze.pages.CartPage;
import com.demoblaze.pages.HomePage;
import com.demoblaze.pages.ProductPage;
import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddtoCart_stepDefs {
    HomePage homePage = new HomePage();
    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();

    @When("The user selects {string} from home page")
    public void the_user_selects_from_home_page(String productName) {
        homePage.selectProduct(productName);
    }

    @When("The user adds the product to the cart")
    public void the_user_adds_the_product_to_the_cart() {
        productPage.clickAddToCart();
        BrowserUtils.waitFor(2);
        Driver.get().switchTo().alert().accept(); // Alert'ı kabul et
    }

    @Then("The user verifies the product is added to cart")
    public void the_user_verifies_the_product_is_added_to_cart() {
        homePage.navigateToMenu("Cart");
        cartPage.verifyProductInCart("Samsung galaxy s6");
    }
}



