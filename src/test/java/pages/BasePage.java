package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

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

    public void verifyTitle(String title) {
        assertEquals(getTitle(), title,
                "Открыта неверная страница. Ожидаемый результат: Страница \"%s\"".formatted(title));
    }
}
