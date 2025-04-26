package com.demoblaze.pages;

import com.demoblaze.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage {
    public void clickAddToCart() {
        Driver.get().findElement(By.xpath("//a[text()='Add to cart']")).click();
    }
}







