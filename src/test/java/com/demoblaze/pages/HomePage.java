package com.demoblaze.pages;

import com.demoblaze.utilities.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage {
    @FindBy(id = "nameofuser")
    public WebElement nameofuser;

    public HomePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    public void verifyWelcomeMessage() {
        BrowserUtils.waitForVisibility(nameofuser, 10);
        String actualMessage = nameofuser.getText();
        Assert.assertTrue(actualMessage.contains(ConfigurationReader.get("username")));
    }
    public void verifyWelcomeMessage(String username) {
        BrowserUtils.waitForVisibility(nameofuser, 10);
        String actualMessage = nameofuser.getText();
        Assert.assertTrue(actualMessage.contains(username));
    }
}


