package com.demoblaze.pages;

import com.demoblaze.utilities.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
    int actualAmount;
    @FindBy(xpath = "//button[.='Place Order']")
    public WebElement placeOrderBtn;
    @FindBy(id = "name")
    public WebElement name;
    @FindBy(id = "country")
    public WebElement country;
    @FindBy(id = "city")
    public WebElement city;
    @FindBy(id = "card")
    public WebElement card;
    @FindBy(id = "month")
    public WebElement month;
    @FindBy(id = "year")
    public WebElement year;
    @FindBy(xpath = "//button[.='Purchase']")
    public WebElement purchaseBtn;
    @FindBy(xpath = "//p[@class='lead text-muted ']")
    public WebElement confirmation;
    @FindBy(xpath = "//button[.='OK']")
    public WebElement ok;

    public int removeProduct(String product) {
        BrowserUtils.waitFor(10);
        navigateToMenu("Cart");
        BrowserUtils.waitFor(10);

        String productPath = "//td[.='" + product + "']";
        String productPricePath = productPath + "/../td[3]";
        String deletePath = productPricePath + "/../td[a]/a";

        String priceText = Driver.get().findElement(By.xpath(productPricePath)).getText();

        Driver.get().findElement(By.xpath(deletePath)).click();
        return Integer.parseInt(priceText);
    }

    public void finishPurchase_logAmount() {
        BrowserUtils.waitFor(1);
        placeOrderBtn.click();
        BrowserUtils.waitFor(1);
        fillForm();
        BrowserUtils.waitFor(1);
        purchaseBtn.click();
        BrowserUtils.waitForVisibility(confirmation, 5);
        String confirmationText = confirmation.getText();
        String[] confirmationArray = confirmationText.split("\n");
        actualAmount = Integer.parseInt(confirmationArray[1].split(" ")[1]);
        BrowserUtils.waitFor(1);
        ok.click();
    }

    void fillForm() {
        BrowserUtils.waitAndSendKeys(name, faker.name().fullName(), 5);
        BrowserUtils.waitAndSendKeys(country, faker.country().name(), 5);
        BrowserUtils.waitAndSendKeys(city, faker.country().capital(), 5);
        BrowserUtils.waitAndSendKeys(card, faker.finance().creditCard(), 5);
        BrowserUtils.waitAndSendKeys(month, String.valueOf(faker.number().numberBetween(1, 12)), 5);
        BrowserUtils.waitAndSendKeys(year, String.valueOf(faker.number().numberBetween(2024, 2030)), 5);
    }

    public void verifyPurchaseAmount(int expectedPurchaseAmount) {
        Assert.assertEquals(expectedPurchaseAmount, actualAmount);
    }

    public void verifyProductInCart(String productName) {
        BrowserUtils.waitFor(3);
        String actualProduct = Driver.get().findElement(By.xpath("//td[2]")).getText();
        Assert.assertEquals(productName, actualProduct);
    }
}