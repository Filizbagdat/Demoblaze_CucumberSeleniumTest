package com.demoblaze.pages;

import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.ConfigurationReader;
import com.demoblaze.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class HomePage extends BasePage{
    @FindBy(id = "nameofuser")
    public WebElement nameofuser;
    @FindBy(css = "[class='price-container']")
    public WebElement priceText;
    @FindBy(linkText = "Add to cart")
    public WebElement addToCartBtn;
    public void verifyWelcomeMessage(){
        BrowserUtils.waitForVisibility(nameofuser,10);
        String actualMessage=nameofuser.getText();
        Assert.assertTrue(actualMessage.contains(ConfigurationReader.get("username")));
    }
    public void verifyWelcomeMessage(String username){
        BrowserUtils.waitForVisibility(nameofuser,10);
        String actualMessage=nameofuser.getText();
        Assert.assertTrue(actualMessage.contains(username));
    }
    public int addProduct(String product,String category){

        try {
            WebElement categoryMenu= Driver.get().findElement(By.linkText(category));
            BrowserUtils.waitForClickablility(categoryMenu,5).click();
        }catch (Exception e){
            BrowserUtils.clickWithWait(By.linkText(category),5);
        }
        try {
            WebElement productItem=Driver.get().findElement(By.linkText(product));
            BrowserUtils.scrollToElement(productItem);
            BrowserUtils.waitForClickablility(productItem,5).click();
        }catch (Exception e){
            BrowserUtils.clickWithWait(By.linkText(product),5);
        }

        String[] arrayAmount=priceText.getText().split(" ");
        int lastPrice= Integer.parseInt(arrayAmount[0].substring(1));

        addToCartBtn.click();
        alert=wait.until(ExpectedConditions.alertIsPresent());
        alert=Driver.get().switchTo().alert();
        alert.accept();

        navigateToMenu("Home");
        return lastPrice;
    }
}