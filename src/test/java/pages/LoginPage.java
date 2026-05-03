package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePage {

    private final By USERNAME_FIELD = By.cssSelector("#user-name");
    private final By PASSWORD_FIELD = By.cssSelector("#password");
    private final By BUTTON_LOGIN = By.cssSelector("#login-button");
    private final By ERROR_MESSAGE = By.xpath("//*[contains(@class, 'error-message')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void authorization(String user, String password) {
        open();
        login(user, password);
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public void login(String user, String password) {
        driver.findElement(USERNAME_FIELD).sendKeys(user);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(BUTTON_LOGIN).click();
    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    public void verifyErrorMessage(String error) {
        Assert.assertEquals(getErrorMessage(), error, "Некорректный текст ошибки.");
    }
}
