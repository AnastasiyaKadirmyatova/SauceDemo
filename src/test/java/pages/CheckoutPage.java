package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public final By BUTTON_CONTINUE = By.xpath("//input[@data-test='continue']");
    private final By ERROR_MESSAGE = By.xpath("//*[contains(@class, 'error-message')]");
    private final By FIRST_NAME = By.cssSelector("#first-name");
    private final By LAST_NAME = By.cssSelector("#last-name");
    private final By POSTAL_CODE = By.cssSelector("#postal-code");

    public void open() {
        driver.get(BASE_URL + "/checkout-step-one.html");
    }

    public void continueOrder() {
        driver.findElement(BUTTON_CONTINUE).click();
    }

    public void verifyErrorMessage(String error) {
        Assert.assertEquals(getErrorMessage(), error, "Некорректный текст ошибки.");
    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    public void addInformation(String firstName, String lastName, String postalCode) {
        addFirstName(firstName);
        addLastName(lastName);
        addPortalCode(postalCode);
    }

    public void addFirstName(String firstName) {
        driver.findElement(FIRST_NAME).sendKeys(firstName);
    }

    public void addLastName(String lastName) {
        driver.findElement(LAST_NAME).sendKeys(lastName);
    }

    public void addPortalCode(String postalCode) {
        driver.findElement(POSTAL_CODE).sendKeys(postalCode);
    }
}
