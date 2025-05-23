package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SonyZ5PhonePage {
    WebDriver chromeDriver;
    public SonyZ5PhonePage(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
    }
//Locators
    private By addtocartbuttonLoc = By.cssSelector(".btn.btn-success.btn-lg");
    private By cartLoc = By.id("cartur");
//Actions
    public void addItemToCart(){
        chromeDriver.findElement(addtocartbuttonLoc).click();
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.alertIsPresent());
    }
    public void acceptAlert(){
        chromeDriver.switchTo().alert().accept();
    }
    public CartPage clickOnCartButton(){
        chromeDriver.findElement(cartLoc).click();
        return new CartPage(chromeDriver);
    }
}