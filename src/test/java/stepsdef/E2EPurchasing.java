package stepsdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CartPage;
import pages.HomePage;
import pages.SonyVaioI5Page;
import pages.SonyZ5PhonePage;

public class E2EPurchasing {
    WebDriver chromeDriver = Hooks.getDriverForCucmber();
    HomePage homePage = new HomePage(chromeDriver);
    SonyZ5PhonePage sonyZ5PhonePage;
    SonyVaioI5Page sonyVaioI5Page;
    CartPage cartPage;
//Variables//
    String expected_productname_1 = homePage.getProduct1Name() ;
    String expected_productprice_1 = homePage.getProduct1Price();
    String expected_productname_2 = homePage.getProduct2name();
    String expected_productprice_2 = homePage.getProduct2price();


    //LogIn First
        @Given("user opens up homepage and click on login button")
        public void user_opens_up_homepage_and_click_on_login_button() {
            homePage.generalWaitUntilElementsLoad();
            homePage.logIn();
        }
        @When("user enters existing username & password and click on login")
        public void user_enters_existing_username_password_and_click_on_login() {
            homePage.insertUsername("v");
            homePage.insertPassword("v");
            homePage.clickOnLogInButton();
        }
        @Then("welcome message appears to user on homepage with his name")
        public void welcome_message_appears_to_user_on_homepage_with_his_name() throws InterruptedException {
            String userIsActuallyLoggedIn = homePage.checkIfUserLoggedIn();
            String expectedMessage = "Welcome";
            Assert.assertTrue(userIsActuallyLoggedIn.contains(expectedMessage));
        }
//Adding first Product (Sony vaio I5 Laptop)
    @Given("user goes to homepage selects first product, adds it to cart and click on homepage")
    public void user_goes_to_homepage_and_click_on_a_product_and_enter_into_the_product_s_page() {
        sonyVaioI5Page = homePage.selectSonyVaioI5Product();
        sonyVaioI5Page.addItemToCart();
        String product1added = chromeDriver.switchTo().alert().getText();
        String added1_message = "Product added";
        Assert.assertTrue(product1added.contains(added1_message));
        sonyVaioI5Page.acceptAlert();
        sonyVaioI5Page.clickOnHomeButton();
    }
//Adding Second Product (Sony Phone)
     @And("user goes to homepage selects second product, adds it to cart and click on cart")
     public void user_goes_to_homepage_and_click_on_a_second_product_and_enter_into_the_product_s_page() throws InterruptedException {
        sonyZ5PhonePage = homePage.selectSonyZ5Product();
        sonyZ5PhonePage.addItemToCart();
        String product2added = chromeDriver.switchTo().alert().getText();
        String added2_message = "Product added";
        Assert.assertTrue(product2added.contains(added2_message));
        sonyZ5PhonePage.acceptAlert();
        cartPage = sonyZ5PhonePage.clickOnCartButton();
    }
//**Cart Checking-Out & Placing Order**//
    @And("validate products' names & prices")
    public void get_the_name_price_of_first_product() {
        String actual_product_1 = cartPage.check_Product1Name();
        Assert.assertTrue(actual_product_1.equals(expected_productname_1));
        String actual_product1price = cartPage.check_Product1Price();
        System.out.println("actual price 1: "+actual_product1price);
        Assert.assertEquals(actual_product1price,expected_productprice_1.replace("$",""));
        String actual_product_2 = cartPage.check_Product2Name();
        Assert.assertTrue(actual_product_2.equals(expected_productname_2));
        String actual_product2price = cartPage.check_Product2Price();
        System.out.println("actual price 2: "+ actual_product2price);
        Assert.assertEquals(actual_product2price,expected_productprice_2.replace("$",""));
    }
    @And("compare the total amount with the sum of selected products")
    public void compare_the_total_amount_with_the_sum_of_selected_products_and_place_order() throws InterruptedException {
        int sonyvaioI5_price = cartPage.intValueForProduct_1();
        int sonyxperiaZ5_price = cartPage.intValueForProduct_2();
        int totalcartamount = cartPage.intTotalCartValue();
        Assert.assertEquals(sonyvaioI5_price+sonyxperiaZ5_price,totalcartamount);
    }
//Client's Purchasing Data
    @When("user clicks on place order button")
    public void the_user_clicks_on_place_order_fills_in_his_data() throws InterruptedException {
        cartPage.placeOrder();
    }
    @And("user fills in his data and click on purchase")
    public void user_clicks_on_purchase_button_get_validation_message() throws InterruptedException {
        cartPage.checkoutName("Tester823020");
        cartPage.checkoutCountry("India");
        cartPage.checkoutCity("New Delhi");
        cartPage.checkoutCreditCard("2387998745678908");
        cartPage.checkoutMonth("4");
        cartPage.checkoutYear("2025");
        cartPage.Purchase();
        String actualPurchaseMessageConfirmation = cartPage.PurchaseConfirmationMessage();
        String expectedPurchaseMessageConfirmation = "Thank you for your purchase!";
        Assert.assertTrue(actualPurchaseMessageConfirmation.contains(expectedPurchaseMessageConfirmation));
    }
    @Then("user receives a confirmation message then clicks ok button ending process")
    public void user_clicks_on_ok_button_ending_the_process() throws InterruptedException {
        cartPage.clickOnOkButton();
    }
}


