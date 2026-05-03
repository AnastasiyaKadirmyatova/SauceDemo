package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static pages.BasePage.getTitle;

public class LoginTest extends BaseTest {

    @Test
    public void checkPositiveCred() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(getTitle(), "Products");
    }

    @Test
    public void checkLoginWithEmptyPassword() {
        loginPage.open();
        loginPage.login("standard_user", "");
        loginPage.verifyErrorMessage("Epic sadface: Password is required");
    }

    @Test
    public void checkLoginWithEmptyUser() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        loginPage.verifyErrorMessage("Epic sadface: Username is required");
    }

    @Test
    public void checkLoginWithIncorrectCred() {
        loginPage.open();
        loginPage.login("test_name", "secret_test");
        loginPage.verifyErrorMessage("Epic sadface: Username and password do not match any user in this service");
    }
}
