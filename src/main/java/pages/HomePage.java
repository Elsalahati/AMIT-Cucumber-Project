package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver chromeDriver;
    WebDriverWait wait;
    Actions actions;

    public HomePage(WebDriver chromeDriver){
        this.chromeDriver = chromeDriver; //passed driver from BaseSteps using Constructor
    }
//*** Locators ***//
    private By signUpLoc = By.id("signin2");
    private By logInLoc = By.id("login2");
    private By cartLoc = By.id("cartur");
    private By homeLoc = By.xpath("//a[contains(text(),'Home ')]");
    //SignUp Locators
    private By signupusernameBoxLoc = By.cssSelector("input[id='sign-username']");
    private By signuppasswordBoxLoc = By.cssSelector("input[id='sign-password']");
    private By completethesignupLoc = By.xpath("//button[contains(text(),'Sign up')]");
    //LogIn Locators
    private By loginusernameLoc  = By.id("loginusername");
    private By loginpasswordLoc = By.id("loginpassword");
    private By completetheloginLoc = By.xpath("//button[contains(text(),'Log in')]");
    private By welcomeSuccessful_Loc = By.id("nameofuser");
    //Selected Products' Locators
    private By sonyvaioI5Loc  = By.xpath("//a[contains(text(),'Sony vaio i5')]");
    private By sonyvaioI5priceLoc = By.xpath("(//h5[not(@*)])[8]");
    private By sonyxperiaZ5Loc = By.xpath("//a[contains(text(),'Sony xperia z5')]");
    private By sonyxperiaZ5priceLoc = By.xpath("(//h5[not(@*)])[6]");
 //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
//*** Pages' Redirection ***//
    public CartPage clickOnCartButton(){
        chromeDriver.findElement(cartLoc).click();
        return new CartPage(chromeDriver);
    }
    public SonyZ5PhonePage selectSonyZ5Product(){
        chromeDriver.findElement(sonyxperiaZ5Loc).click();
        return new SonyZ5PhonePage(chromeDriver);
    }
    public SonyVaioI5Page selectSonyVaioI5Product(){
        chromeDriver.findElement(sonyvaioI5Loc).click();
        return new SonyVaioI5Page(chromeDriver);
    }
//*** Page Actions ***//
    public void generalWaitUntilElementsLoad(){
       wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(5));
       wait.until(ExpectedConditions.visibilityOf(chromeDriver.findElement(sonyvaioI5Loc)));
}
    public void signUpForm(){  //First Sign-up
        chromeDriver.findElement(signUpLoc).click();
    }
    public void signUpNewUsername(String username){
        wait = new WebDriverWait(chromeDriver,Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(chromeDriver.findElement(signupusernameBoxLoc)));
        chromeDriver.findElement(signupusernameBoxLoc).sendKeys(username);
    }
    public void signUpNewPassword(String password){
        chromeDriver.findElement(signuppasswordBoxLoc).sendKeys(password);
    }
    public void clickOnSignUpButton(){
        chromeDriver.findElement(completethesignupLoc).click();
    }
    public String getSign_UpValidation(){
        wait = new WebDriverWait(chromeDriver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        String successmessage = chromeDriver.switchTo().alert().getText();
        return successmessage;
    }
    public void acceptSuccessfulAlert(){
        chromeDriver.switchTo().alert().accept();
    }
    public void logIn(){
        chromeDriver.findElement(logInLoc).click();
    }
    public void insertUsername(String username){
        wait = new WebDriverWait(chromeDriver,Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(chromeDriver.findElement(loginusernameLoc))).isDisplayed();
        chromeDriver.findElement(loginusernameLoc).sendKeys(username);
    }
    public void insertPassword(String password){
        chromeDriver.findElement(loginpasswordLoc).sendKeys(password);
    }
    public void clickOnLogInButton(){
        chromeDriver.findElement(completetheloginLoc).click();
        wait = new WebDriverWait(chromeDriver,Duration.ofSeconds(3));
        wait.until(ExpectedConditions.invisibilityOf(chromeDriver.findElement(completetheloginLoc)));
    }
    public String checkIfUserLoggedIn(){
        wait = new WebDriverWait(chromeDriver,Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(chromeDriver.findElement(welcomeSuccessful_Loc))).isDisplayed();
        return chromeDriver.findElement(welcomeSuccessful_Loc).getText();
    }
//Selected Products' Info
    //Product 1
    public String getProduct1Name(){
        String name = chromeDriver.findElement(sonyvaioI5Loc).getText();
        return name;
    }
    public String getProduct1Price(){
        String price = chromeDriver.findElement(sonyvaioI5priceLoc).getText();
        return price;
    }
    //Product 2
    public String getProduct2name(){
        String name = chromeDriver.findElement(sonyxperiaZ5Loc).getText();
        return name;
    }
    public String getProduct2price(){
        String price = chromeDriver.findElement(sonyxperiaZ5priceLoc).getText();
        return price;
    }
//(*Bonus*) Non-Existing User LogIn
    public void logInWrongUserButton(){
        chromeDriver.findElement(completetheloginLoc).click();
    }
    public String nonExistingUserAlertMessage(){
        wait = new WebDriverWait(chromeDriver,Duration.ofSeconds(5));
       return wait.until(ExpectedConditions.alertIsPresent()).getText();
    }
    public void acceptAlertMessage() {
        chromeDriver.switchTo().alert().accept();
    }
}
