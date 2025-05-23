package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    WebDriver chromeDriver;
    WebDriverWait wait;
    public CartPage(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
    }
//*** Locators ***//
    private By product1nameLoc = By.xpath("//td[contains(text(),'Sony vaio i5')]");
    private By product1priceLoc = By.xpath("//tr[td[contains(text(), 'Sony vaio i5')]]/td[contains(text(), '790')]");
    private By product2nameLoc = By.xpath("//td[contains(text(),'Sony xperia z5')]");
    private By product2priceLoc = By.xpath("//tr[td[contains(text(), 'Sony xperia z5')]]/td[contains(text(), '320')]");
    private By totalamountLoc = By.id("totalp");
    private By placeOrderButtonLoc = By.cssSelector(".btn.btn-success");
    //Checkout Data Locators
    private By checkout_nameboxLoc = By.cssSelector("#name:nth-child(2)");
    private By checkout_countryLoc = By.cssSelector("#country:nth-child(2)");
    private By checkout_cityboxLoc = By.cssSelector("#city:nth-child(2)");
    private By checkout_creditcardboxLoc = By.cssSelector("#card:nth-child(2)");
    private By checkout_monthboxLoc = By.cssSelector("#month:nth-child(2)");
    private By checkout_yearboxLoc = By.cssSelector("#year:nth-child(2)");
    private By purchasebuttonLoc = By.xpath("//button[contains(text(),'Purchase')]");
    private By purchasesuccessfulmessageLoc = By.xpath("//h2[contains(text(),'Thank you for your purchase!')]");
    private By okbuttonLoc = By.cssSelector(".confirm.btn.btn-lg.btn-primary");
 //*****************************************************************************************************************//
//Actions
    public String check_Product1Name(){
        return chromeDriver.findElement(product1nameLoc).getText();
    }
     public String check_Product1Price(){
        return chromeDriver.findElement(product1priceLoc).getText();
    }
    public String check_Product2Name(){
        return chromeDriver.findElement(product2nameLoc).getText();
    }
    public String check_Product2Price(){
        return chromeDriver.findElement(product2priceLoc).getText();
    }
    public int intValueForProduct_1(){
        return Integer.parseInt(chromeDriver.findElement(product1priceLoc).getText().trim());
    }
    public int intValueForProduct_2(){
        return Integer.parseInt(chromeDriver.findElement(product2priceLoc).getText().trim());
    }
    public int intTotalCartValue(){
        return Integer.parseInt(chromeDriver.findElement(totalamountLoc).getText().trim());
    }
    public void placeOrder(){
        chromeDriver.findElement(placeOrderButtonLoc).click();
    }
    //Purchasing Info
    public void checkoutName(String name){
        wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(chromeDriver.findElement(checkout_nameboxLoc)));
        chromeDriver.findElement(checkout_nameboxLoc).sendKeys(name);
    }
    public void checkoutCountry(String country){
        chromeDriver.findElement(checkout_countryLoc).sendKeys(country);
    }
    public void checkoutCity(String city){
        chromeDriver.findElement(checkout_cityboxLoc).sendKeys(city);
    }
    public void checkoutCreditCard(String cardnumber){
        chromeDriver.findElement(checkout_creditcardboxLoc).sendKeys(cardnumber);
    }
    public void checkoutMonth(String month){
        chromeDriver.findElement(checkout_monthboxLoc).sendKeys(month);
    }
    public void checkoutYear(String year){
        chromeDriver.findElement(checkout_yearboxLoc).sendKeys(year);
    }
    public void Purchase(){
        chromeDriver.findElement(purchasebuttonLoc).click();
    }
    public String PurchaseConfirmationMessage(){
        return chromeDriver.findElement(purchasesuccessfulmessageLoc).getText();
    }
    public void clickOnOkButton(){
        chromeDriver.findElement(okbuttonLoc).click();
    }
}
