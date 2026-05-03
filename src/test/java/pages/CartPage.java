package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;

public class CartPage extends BasePage {

    private final By BUTTON_CONTINUE_SHOPPING = By.xpath("//*[text()='Continue Shopping']");
    private final By BUTTON_CHECKOUT = By.xpath("//*[text()='Checkout']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public By getProduct(String product) {
        return By.xpath("//div[text()='%s']//ancestor::div[@class='cart_item']".formatted(product));
    }

    private By getRemoveProduct(String product) {
        return By.xpath("//div[text()='%s']".formatted(product) +
                "//ancestor::div[@class='cart_item']//button[text()='Remove']");
    }

    public void open() {
        driver.get(BASE_URL + "/cart.html");
    }

    public CartPage removeProduct(String product) {
        driver.findElement(getRemoveProduct(product)).click();
        return this;
    }

    public void continueShopping() {
        driver.findElement(BUTTON_CONTINUE_SHOPPING).click();
    }

    public void checkout() {
        driver.findElement(BUTTON_CHECKOUT).click();
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
