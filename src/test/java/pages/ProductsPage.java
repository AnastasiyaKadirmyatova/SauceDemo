package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    private final By BUTTON_CART = By.xpath("//a[@class='shopping_cart_link']");

    public void open() {
        driver.get(BASE_URL + "/inventory.html");
    }

    private By getButtonAddProduct(String product) {
        return By.xpath("//div[text()='%s']".formatted(product) +
                "//ancestor::div[@class='inventory_item']//button[text()='Add to cart']");
    }

    public ProductsPage addCartProduct(String product) {
        driver.findElement(getButtonAddProduct(product)).click();
        return this;
    }

    public void openCart() {
        driver.findElement(BUTTON_CART).click();
    }
}
