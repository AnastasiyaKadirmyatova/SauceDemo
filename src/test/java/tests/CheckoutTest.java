package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static pages.CheckoutPage.getErrorMessage;

public class CheckoutTest extends BaseTest {

    @Test(testName = "Проверка открытия страницы \"Ваша информация\"",
            description = "Проверка открытия страницы \"Ваша информация\"",
            groups = {"checkout", "smoke"})
    public void verifyOpenInformationPage() {
        loginPage.authorization("standard_user", "secret_sauce");
        productsPage.openCart();
        cartPage.checkout();
        verifyTitle("Checkout: Your Information");
    }

    @DataProvider(name = "Тестовые данные для негативных проверок страницы \"Checkout\"")
    public Object[][] informationData() {
        return new Object[][]{
                {"", "Ivanova", "Moscow", "Error: First Name is required"},
                {"Mariya", "", "Moscow", "Error: Last Name is required"},
                {"Mariya", "Ivanova", "", "Error: Postal Code is required"}
        };
    }

    @Test(testName = "Проверка оформления заказа с невалидными данными",
            description = "Проверка оформления заказа с пустым полем в информации",
            groups = {"checkout", "smoke"},
            dataProvider = "Тестовые данные для негативных проверок страницы \"Checkout\"")
    public void verifyContinueOrderWithInformation(String firstName, String LastName, String postalCode, String errorMessage) {
        String product = "Sauce Labs Bike Light";

        loginPage.authorization("standard_user", "secret_sauce");
        productsPage
                .addCartProduct(product)
                .openCart();
        cartPage.checkout();
        checkoutPage.addInformation(firstName, LastName, postalCode);
        checkoutPage.continueOrder();
        verifyErrorMessage(errorMessage);
    }

    public void verifyErrorMessage(String error) {
        Assert.assertEquals(getErrorMessage(), error, "Некорректный текст ошибки.");
    }
}
