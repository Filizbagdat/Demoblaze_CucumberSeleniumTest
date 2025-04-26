package com.demoblaze.step_definitions;

import com.demoblaze.pages.HomePage;
import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;

public class SignUp_stepDefs {


    HomePage homePage = new HomePage();

    @When("The user clicks on Sign up button")
    public void the_user_clicks_on_sign_up_button() {
        homePage.signUpButton.click();
        BrowserUtils.waitFor(1);
    }

    @When("The user enters a unique username and password")
    public void the_user_enters_a_unique_username_and_password() {
        String username = "User" + System.currentTimeMillis(); // her seferinde farklı
        homePage.signupUsername.sendKeys(username);
        homePage.signupPassword.sendKeys("Test1234");
    }

    @When("The user confirms sign up")
    public void the_user_confirms_sign_up() {
        homePage.signupConfirmButton.click();
    }

    @Then("The user should see successful signup alert")
    public void the_user_should_see_successful_signup_alert() {
        BrowserUtils.waitFor(2);
        Alert alert = Driver.get().switchTo().alert();
        String message = alert.getText();
        Assert.assertEquals("Sign up successful.", message);
        alert.accept();
    }


    @When("The user enters username {string} and password {string}")
    public void the_user_enters_username_and_password(String username, String password) {
        homePage.signupUsername.sendKeys(username);
        homePage.signupPassword.sendKeys(password);
        BrowserUtils.waitFor(1);
    }

    @When("The user clicks Sign up to submit")
    public void the_user_clicks_sign_up_to_submit() {
        homePage.signupConfirmButton.click();
        BrowserUtils.waitFor(2);
    }

    @Then("The user should see an alert saying {string}")
    public void the_user_should_see_an_alert_saying(String expectedMessage) {
        Alert alert = Driver.get().switchTo().alert();
        String actualMessage = alert.getText();
        System.out.println("Alert message: " + actualMessage);
        Assert.assertEquals(expectedMessage, actualMessage);
        alert.accept();
    }
}


