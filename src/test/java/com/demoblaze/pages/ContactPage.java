package com.demoblaze.pages;

import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ContactPage extends BasePage{



    @FindBy (id = "recipient-email")
     public WebElement emailField;

    @FindBy (id = "recipient-name")
    public WebElement nameField;

    @FindBy (id = "message-text")
    public WebElement messageField;

    @FindBy (xpath = "//button[@onclick='send()']")
    public WebElement submitButton;


    public void fillForm1() {

        BrowserUtils.waitAndSendKeys(emailField, String.valueOf(faker.address()), 5);
        BrowserUtils.waitAndSendKeys(nameField, faker.name().fullName(), 5);
        BrowserUtils.waitAndSendKeys(messageField, String.valueOf(faker.name()), 5);
        submitButton.click();

    }

    public void verifyAccessMessage(String expectedMessage){
        BrowserUtils.waitFor(1);
        alert= Driver.get().switchTo().alert();
        wait.until(ExpectedConditions.alertIsPresent());
        String actualMessage= alert.getText();
        Assert.assertEquals(expectedMessage,actualMessage);
        alert.accept();
    }
    }


