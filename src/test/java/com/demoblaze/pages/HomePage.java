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
    @FindBy(xpath = "//a[text()='Phones']")
    public WebElement phonesCategory;
    @FindBy(xpath = "//a[text()='Laptops']")
    public WebElement laptopsCategory;
    @FindBy(xpath = "//a[text()='Monitors']")
    public WebElement monitorsCategory;
    @FindBy(xpath = "//div[@class='card-block']//h4[@class='card-title']/a")
    public List<WebElement> productNames;

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
    public void verifyProduct1() {
        BrowserUtils.waitFor(3); // 2'den 3 saniyeye çıkardık
        for (WebElement product : productNames) {
            Assert.assertFalse("Product name is empty!", product.getText().trim().isEmpty());
        }
    }
    public void verifyProduct2() {
        BrowserUtils.waitFor(3); // 2'den 3 saniyeye çıkardık
        for (WebElement product : productNames) {
            Assert.assertFalse("Product name is empty!", product.getText().trim().isEmpty());
        }
    }
    public void verifyProduct3() {
        BrowserUtils.waitFor(3); // 2'den 3 saniyeye çıkardık
        for (WebElement product : productNames) {
            Assert.assertFalse("Product name is empty!", product.getText().trim().isEmpty());
        }
    }
}

