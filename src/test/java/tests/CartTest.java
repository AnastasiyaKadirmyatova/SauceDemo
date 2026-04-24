package tests;

import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void verifyAddToCart() {
        String product = "Sauce Labs Bike Light";

        loginPage.authorization("standard_user", "secret_sauce");
        productsPage
                .addCartProduct(product)
                .openCart();
        cartPage.verifyProductInCart(product);
    }

    @Test
    public void verifyRemove() {
        String product = "Sauce Labs Bike Light";

        loginPage.authorization("standard_user", "secret_sauce");
        productsPage
                .addCartProduct(product)
                .openCart();
        cartPage
                .removeProduct(product)
                .verifyNoProductInCart(product);
    }

    @Test
    public void verifyOpenCartPage() {
        loginPage.authorization("standard_user", "secret_sauce");
        productsPage.openCart();
        cartPage.verifyTitle("Your Cart");
    }
}
