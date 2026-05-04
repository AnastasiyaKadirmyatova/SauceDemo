package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    static WebDriver driver;
    public final String BASE_URL = "https://www.saucedemo.com/";
    public static final By TITLE_PAGE = By.xpath("//*[@data-test='title']");

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public static String getTitle() {
        return driver.findElement(TITLE_PAGE).getText();
    }


}
