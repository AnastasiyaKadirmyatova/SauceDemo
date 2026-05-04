package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static pages.BasePage.getTitle;
import static pages.CheckoutPage.getErrorMessage;

public class LoginTest extends BaseTest {

    @Test(testName = "Авторизация с валидными данными",
    description = "Авторизация с валидными данными",
    groups = {"login", "smoke"})
    public void checkPositiveCred() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(getTitle(), "Products");
    }

    @DataProvider(name = "Тестовые данные для негативных проверок входа")
    public Object[][] loginData() {
            return new Object[][] {
                    {"standard_user", "", "Epic sadface: Password is required"},
                    {"", "secret_sauce", "Epic sadface: Username is required"},
                    {"test_name", "secret_test", "Epic sadface: Username and password do not match any user in this service"}
            };
    }

    @Test(testName = "Авторизация с невалидными данными",
            description = "Авторизация с пустым полем",
            groups = {"login", "regression"},
            dataProvider = "Тестовые данные для негативных проверок входа")
    public void negativeLogin(String userName, String password, String errorMessage) {
        loginPage.open();
        loginPage.login(userName, password);
        verifyErrorMessage(errorMessage);
    }

    public void verifyErrorMessage(String error) {
        Assert.assertEquals(getErrorMessage(), error, "Некорректный текст ошибки.");
    }
}
