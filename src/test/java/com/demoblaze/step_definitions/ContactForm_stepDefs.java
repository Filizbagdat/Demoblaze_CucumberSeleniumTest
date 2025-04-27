package com.demoblaze.step_definitions;

import com.demoblaze.pages.ContactPage;
import com.demoblaze.utilities.BrowserUtils;
import io.cucumber.java.en.*;

public class ContactForm_stepDefs {
    ContactPage contactPage = new ContactPage();
    @When("User is on the contact page")
    public void userIsOnTheContactPage() {
        BrowserUtils.waitFor(4);
        contactPage.navigateToMenu("Contact");
        BrowserUtils.waitFor(4);
        contactPage.fillForm1();
    }
    @Then("The user verifies message")
    public void theUserVerifiesMessage() {
        contactPage.verifyAccessMessage("Thanks for the message!!");
        contactPage.navigateToMenu("Home");
    }
}


