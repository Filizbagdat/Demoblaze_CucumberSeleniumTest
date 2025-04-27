package com.demoblaze.pages;

import com.demoblaze.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(),this);
    }
    public Alert alert;
    public WebDriverWait wait=new WebDriverWait(Driver.get(), Duration.ofSeconds(10));
    public Faker faker=new Faker();

    public void navigateToMenu(String menu){
        By l_menu=By.partialLinkText(menu);
        wait.until(ExpectedConditions.visibilityOfElementLocated(l_menu)).click();
    }
}









