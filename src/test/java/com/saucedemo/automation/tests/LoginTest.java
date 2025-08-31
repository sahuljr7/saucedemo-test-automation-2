package com.saucedemo.automation.tests;

import com.saucedemo.automation.base.BaseTest;
import com.saucedemo.automation.pages.HomePage;
import com.saucedemo.automation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(homePage.getTitle(), "Products", "Login Failed!");
    }
}
