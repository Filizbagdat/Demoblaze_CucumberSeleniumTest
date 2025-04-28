package com.demoblaze.pages;

import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//h3[@class='price-container']")
    public WebElement priceElement;
    @FindBy(xpath = "//a[text()='Add to cart']")
    public WebElement addToCartButton;
    @FindBy(xpath = "//h2[@class='name']")
    public WebElement productName;
    CartPage cartPage = new CartPage();
    String productPrice;

    public void clickAddToCart() {
        Driver.get().findElement(By.xpath("//a[text()='Add to cart']")).click();
        BrowserUtils.waitFor(2);
        Driver.get().switchTo().alert().accept();
    }

    public void selectProduct(String productName) {
        BrowserUtils.waitFor(4);
        Driver.get().findElement(By.linkText(productName)).click();
    }

    public void getprice() {
        BrowserUtils.waitForVisibility(priceElement, 5);
        productPrice = priceElement.getText();
    }

    public void priceControl() {
        String cartPrice = cartPage.cartProductPrice.getText();
        String expectedPrice = productPrice.replaceAll("[^0-9]", "");
        String actualPrice = cartPrice.replaceAll("[^0-9]", "");
        Assert.assertEquals(expectedPrice, actualPrice);
    }

    public void clickCategory(String category) {
        BrowserUtils.waitFor(3);

        Driver.get().findElement(By.linkText(category)).click();

        BrowserUtils.waitFor(3);

    }

    public boolean isCategoryDisplayed(String category) {
        Assert.assertTrue(Driver.get().findElement(By.linkText(category)).isDisplayed());
        return true;
    }
}







