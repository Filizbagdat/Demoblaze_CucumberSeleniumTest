package com.demoblaze.pages;

import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage {

    @FindBy(id = "signin2")
    public WebElement signUpButton;
    @FindBy(id = "sign-username")
    public WebElement signupUsername;
    @FindBy(id = "sign-password")
    public WebElement signupPassword;
    @FindBy(xpath = "//button[text()='Sign up']")
    public WebElement signupConfirmButton;

    public void signUp() {
        String username = "User" + System.currentTimeMillis(); // her seferinde farklı
        signupUsername.sendKeys(username);
        signupPassword.sendKeys("Test1234");
    }
    public void verifyMsg () {
        BrowserUtils.waitFor(2);
        Alert alert = Driver.get().switchTo().alert();
        String message = alert.getText();
        Assert.assertEquals("Sign up successful.", message);
        alert.accept();
    }
    public void verifyWarningMsg (String expectedMessage){
        Alert alert = Driver.get().switchTo().alert();
        String actualMessage = alert.getText();
        System.out.println("Alert message: " + actualMessage);
        Assert.assertEquals(expectedMessage, actualMessage);
        alert.accept();
    }
}
