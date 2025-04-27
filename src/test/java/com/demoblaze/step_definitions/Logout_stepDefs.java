package com.demoblaze.step_definitions;

import com.demoblaze.pages.HomePage;
import com.demoblaze.pages.LoginPage;
import com.demoblaze.pages.LogoutPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Logout_stepDefs {
    HomePage homepage = new HomePage();
    LoginPage loginpage = new LoginPage();
    LogoutPage logoutpage = new LogoutPage();

    @Given("The user login the website")
    public void theUserLoginTheWebsite() {
        loginpage.login();
    }
    @When("The user clicks logout button")
    public void theUserClicksLogoutButton() {
        logoutpage.logoutBtn.click();
    }
    @Then("The user logs out")
    public void theUserLogsOut() {
        Assert.assertFalse(homepage.nameofuser.isDisplayed());
    }
    @Then("The user should not see the logout button")
    public void the_user_should_not_see_the_logout_button() {
       logoutpage.logoutBtnControl();
    }
}

