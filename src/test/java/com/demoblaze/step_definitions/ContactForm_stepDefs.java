package com.demoblaze.step_definitions;

import com.demoblaze.pages.ContactPage;
import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;


public class ContactForm_stepDefs {
    ContactPage contactPage = new ContactPage();
    public Alert alert;
    public WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(10));


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
    @When("The user clicks on Contact menu")
    public void the_user_clicks_on_contact_menu() {
        contactPage.navigateToMenu("Contact");
        BrowserUtils.waitFor(1);
    }

    @When("The user fills contact form with name {string}, empty email and message {string}")
    public void the_user_fills_contact_form_with_name_empty_email_and_message(String name, String message) {
        contactPage.nameField.sendKeys(name);
        contactPage.emailField.clear(); // e-mail boş
        contactPage.messageField.sendKeys(message);
        BrowserUtils.waitFor(1);
    }

    @When("The user clicks Send Message")
    public void the_user_clicks_send_message() {
        contactPage.submitButton.click();
        BrowserUtils.waitFor(2);
    }



    @Then("The user should see an alert {string}")
    public void theUserShouldSeeAnAlert(String expectedMessage) {
        Alert alert = Driver.get().switchTo().alert();
        String actualMessage = alert.getText();

        Assert.assertEquals(expectedMessage, actualMessage);
        alert.accept();

    }
}


