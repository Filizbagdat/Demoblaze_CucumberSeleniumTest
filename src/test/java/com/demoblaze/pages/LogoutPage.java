package com.demoblaze.pages;

import com.demoblaze.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage{
    @FindBy(id = "logout2" )
    public WebElement logoutBtn;
    public void logoutBtnControl() {
        BrowserUtils.waitFor(2);
        boolean isLogoutButtonVisible = logoutBtn.isDisplayed();
        Assert.assertFalse("Logout button should not be visible when the user is not logged in", isLogoutButtonVisible);
    }
}
