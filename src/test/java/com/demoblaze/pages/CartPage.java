package com.demoblaze.pages;

import com.demoblaze.utilities.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
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
    @FindBy(xpath = "//tr[@class='success']/td[3]")
    public WebElement cartProductPrice;
    @FindBy(xpath = "//tr[@class='success']")
    public List<WebElement> cartProductRows;
    @FindBy(css = "[class='price-container']")
    public WebElement priceText;
    @FindBy(linkText = "Add to cart")
    public WebElement addToCartBtn;
    @FindBy(xpath = "(//a[@class='hrefch'])[1]")
    public WebElement firstProduct;
    @FindBy(id = "cartur")
    public WebElement cartButton;

    public int addProduct(String product, String category) {

        try {
            WebElement categoryMenu = Driver.get().findElement(By.linkText(category));
            BrowserUtils.waitForClickablility(categoryMenu, 5).click();
        } catch (Exception e) {
            BrowserUtils.clickWithWait(By.linkText(category), 5);
        }
        try {
            WebElement productItem = Driver.get().findElement(By.linkText(product));
            BrowserUtils.scrollToElement(productItem);
            BrowserUtils.waitForClickablility(productItem, 5).click();
        } catch (Exception e) {
            BrowserUtils.clickWithWait(By.linkText(product), 5);
        }

        String[] arrayAmount = priceText.getText().split(" ");
        int lastPrice = Integer.parseInt(arrayAmount[0].substring(1));

        addToCartBtn.click();
        alert = wait.until(ExpectedConditions.alertIsPresent());
        alert = Driver.get().switchTo().alert();
        alert.accept();

        navigateToMenu("Home");
        return lastPrice;
    }
    public int removeProduct(String product) {
       // BrowserUtils.waitFor(10);
        navigateToMenu("Cart");
      //  BrowserUtils.waitFor(10);

        String productPath = "//td[.='" + product + "']";
        String productPricePath = productPath + "/../td[3]";
        String deletePath = productPricePath + "/../td[a]/a";

        String priceText = Driver.get().findElement(By.xpath(productPricePath)).getText();

        Driver.get().findElement(By.xpath(deletePath)).click();
        return Integer.parseInt(priceText);

          /*  WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(10));

            navigateToMenu("Cart");

            String productPath = "//td[.='" + product + "']";
            String productPricePath = productPath + "/../td[3]";
            String deletePath = productPricePath + "/../td[a]/a";

            // Wait for product price to be visible
            WebElement priceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(productPricePath)));
            String priceText = priceElement.getText();

            // Wait for delete button to be clickable and click it
            WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(deletePath)));
            deleteButton.click();

            return Integer.parseInt(priceText);*/
        }






    void fillForm() {
        BrowserUtils.waitAndSendKeys(name, faker.name().fullName(), 5);
        BrowserUtils.waitAndSendKeys(country, faker.country().name(), 5);
        BrowserUtils.waitAndSendKeys(city, faker.country().capital(), 5);
        BrowserUtils.waitAndSendKeys(card, faker.finance().creditCard(), 5);
        BrowserUtils.waitAndSendKeys(month, String.valueOf(faker.number().numberBetween(1, 12)), 5);
        BrowserUtils.waitAndSendKeys(year, String.valueOf(faker.number().numberBetween(2024, 2030)), 5);
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




        /*    WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(10));

            wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn)).click();

            fillForm();

            wait.until(ExpectedConditions.elementToBeClickable(purchaseBtn)).click();

            WebElement confirmationElement = wait.until(ExpectedConditions.visibilityOf(confirmation));
            String confirmationText = confirmationElement.getText();
            String[] confirmationArray = confirmationText.split("\n");
            actualAmount = Integer.parseInt(confirmationArray[1].split(" ")[1]);

            wait.until(ExpectedConditions.elementToBeClickable(ok)).click();*/
        }


    public void verifyPurchaseAmount(int expectedPurchaseAmount) {
        Assert.assertEquals(expectedPurchaseAmount, actualAmount);
    }
    public void verifyProductInCart(String productName) {
        BrowserUtils.waitFor(3);
        String actualProduct = Driver.get().findElement(By.xpath("//td[2]")).getText();
        Assert.assertEquals(productName, actualProduct);

      /*  WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(10));
        WebElement productElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[2]")));
        String actualProduct = productElement.getText();
        Assert.assertEquals(productName, actualProduct);*/



    }
    public void verifyCartEmpty() {
        cartButton.click();
        BrowserUtils.waitFor(2);

        List<WebElement> cartItems = cartProductRows;
        Assert.assertTrue("Cart is not empty after purchase!", cartItems.isEmpty());

        /*cartButton.click();

WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(10));
wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//table[@class='table table-bordered table-hover table-striped']/tbody/tr")));

List<WebElement> cartItems = cartProductRows;
Assert.assertTrue("Cart is not empty after purchase!", cartItems.isEmpty());
*/
    }
    }
