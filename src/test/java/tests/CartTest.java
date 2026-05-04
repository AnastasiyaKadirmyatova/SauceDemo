package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static pages.CartPage.getProduct;

public class CartTest extends BaseTest {

    @Test(testName = "Добавление товара в корзину",
            description = "Добавление товара в корзину",
            groups = {"cart", "smoke"},
            retryAnalyzer = Retry.class)
    public void verifyAddToCart() {
        String product = "Sauce Labs Bike Light";

        loginPage.authorization("standard_user", "secret_sauce");
        productsPage
                .addCartProduct(product)
                .openCart();
        verifyProductInCart(product);
    }

    @Test(testName = "Удаление товара из корзины",
            description = "Удаление товара из корзины",
            groups = {"cart", "smoke"})
    public void verifyRemove() {
        String product = "Sauce Labs Bike Light";

        loginPage.authorization("standard_user", "secret_sauce");
        productsPage
                .addCartProduct(product)
                .openCart();
        cartPage.removeProduct(product) ;
        verifyNoProductInCart(product);
    }

    @Test(testName = "Проверка открытия страницы \"Корзина\"",
            description = "Проверка открытия страницы \"Корзина\"",
            groups = {"cart", "smoke"})
    public void verifyOpenCartPage() {
        loginPage.authorization("standard_user", "secret_sauce");
        productsPage.openCart();
        verifyTitle("Your Cart");
    }

    public void verifyProductInCart(String product) {
        assertTrue(driver.findElements(getProduct(product)).size() > 0,
                "Товар с наименованием %s не отображается в корзине".formatted(product));
    }

    public void verifyNoProductInCart(String product) {
        assertTrue(driver.findElements(getProduct(product)).isEmpty(),
                "Товар с наименованием %s отображается в корзине".formatted(product));
    }
}
