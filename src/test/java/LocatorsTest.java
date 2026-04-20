import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.HashMap;

public class LocatorsTest {

    @Test
    public void checkLocator() {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--incognito");
        options.addArguments("--disable-notification");
        options.addArguments("--disable-popup_blocking");
        options.addArguments("--disable-infobars");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("#login-button")).click();
        //id
        driver.findElement(By.id("root"));
        //name
        driver.findElements(By.name("viewport"));
        //classname
        driver.findElement(By.className("bm-menu"));
        //tagname
        driver.findElements(By.tagName("button"));
        //linktext
        driver.findElement(By.linkText("Twitter"));
        //partiallinktext
        driver.findElement(By.partialLinkText("facebook"));
        //xpath:
        // поиск по атрибуту
        driver.findElement(By.xpath("//div[@class='footer_copy']"));
        // поиск по тексту
        driver.findElement(By.xpath("//title[text()='Swag Labs']"));
        //поиск по частичному совпадению атрибута, например
        driver.findElement(By.xpath("//div[contains(@class, 'item_label')]"));
        // поиск по частичному совпадению текста, например
        driver.findElement(By.xpath("//span[contains(text(), 'Name')]"));
        //ancestor
        driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']//ancestor::div[contains(@class, 'item_description')] "));
        //descendant
        driver.findElement(By.xpath("//div[contains(@class, 'item_description')]//descendant::button"));
        //following
        driver.findElement(By.xpath("//div[@class='pricebar']//following::div"));
        //parent
        driver.findElement(By.xpath("//button[contains(@class,'btn_inventory')]//parent::*"));
        //preceding
        driver.findElement(By.xpath("//div[@class='pricebar']//preceding::div[contains(@class,'item')]"));
        // поиск элемента с условием AND
        driver.findElement(By.xpath("//div[contains(@class,'item_name') and contains(text(),'Bike Light')]"));

        //css:
        driver.findElement(By.cssSelector(".inventory_item"));
        driver.findElement(By.cssSelector(".btn.btn_primary"));
        driver.findElement(By.cssSelector("#root"));
        driver.findElement(By.cssSelector("button"));
        driver.findElement(By.cssSelector("div.primary_header"));
        driver.findElement(By.cssSelector("[data-test='primary-header']"));
        driver.findElement(By.cssSelector("[class~='cart']"));
        driver.findElement(By.cssSelector("[class|='btn']"));
        driver.findElement(By.cssSelector("[class^=bm-item]"));
        driver.findElement(By.cssSelector("[class$=list]"));
        driver.findElement(By.cssSelector("[class*=item]"));

        driver.quit();
    }
}
