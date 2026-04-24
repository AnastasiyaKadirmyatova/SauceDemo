package tests;

import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test
    public void verifyOpenInformationPage() {
        loginPage.authorization("standard_user", "secret_sauce");
        productsPage.openCart();
        cartPage.checkout();
        basePage.verifyTitle("Checkout: Your Information");
    }

    @Test
    public void verifyContinueOrderWithEmptyInformation() {
        String product = "Sauce Labs Bike Light";

        loginPage.authorization("standard_user", "secret_sauce");
        productsPage
                .addCartProduct(product)
                .openCart();
        cartPage.checkout();
        checkoutPage.continueOrder();
        checkoutPage.verifyErrorMessage("Error: First Name is required");
    }

    @Test
    public void verifyContinueOrderWithInformation() {
        String product = "Sauce Labs Bike Light";

        loginPage.authorization("standard_user", "secret_sauce");
        productsPage
                .addCartProduct(product)
                .openCart();
        cartPage.checkout();
        checkoutPage.addInformation("Anna", "Ivanova", "NewYork");
        checkoutPage.continueOrder();
        basePage.verifyTitle("Checkout: Overview");
    }
}
