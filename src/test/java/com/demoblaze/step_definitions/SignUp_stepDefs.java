package com.demoblaze.step_definitions;

import com.demoblaze.pages.SignUpPage;
import com.demoblaze.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignUp_stepDefs {

    SignUpPage signUpPage = new SignUpPage();
    @When("The user clicks on Sign up button")
    public void the_user_clicks_on_sign_up_button() {
        signUpPage.signUpButton.click();
        BrowserUtils.waitFor(1);
    }
    @When("The user enters a unique username and password")
    public void the_user_enters_a_unique_username_and_password() {
        signUpPage.signUp();
    }
    @When("The user confirms sign up")
    public void the_user_confirms_sign_up() {
        signUpPage.signupConfirmButton.click();
    }
    @Then("The user should see successful signup alert")
    public void the_user_should_see_successful_signup_alert() {
        signUpPage.verifyMsg();
    }
    @When("The user enters username {string} and password {string}")
    public void the_user_enters_username_and_password(String username, String password) {
        signUpPage.signupUsername.sendKeys(username);
        signUpPage.signupPassword.sendKeys(password);
        BrowserUtils.waitFor(1);
    }
    @When("The user clicks Sign up to submit")
    public void the_user_clicks_sign_up_to_submit() {
        signUpPage.signupConfirmButton.click();
        BrowserUtils.waitFor(2);
    }
    @Then("The user should see an alert saying {string}")
    public void the_user_should_see_an_alert_saying(String expectedMessage) {
        signUpPage.verifyWarningMsg(expectedMessage);
    }
}


