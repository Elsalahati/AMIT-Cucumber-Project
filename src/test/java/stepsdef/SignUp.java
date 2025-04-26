package stepsdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;

public class SignUp {
    WebDriver chromeDriver = Hooks.getDriverForCucmber();
    HomePage homePage = new HomePage(chromeDriver);

    @Given("user opens up homepage and click on signup button")
    public void user_opens_up_homepage_and_click_on_signup_button() {
        homePage.signUpForm();
    }
//SignUp New User (Happy Scenario)
    @When("user enters new username & password and click on signup")
    public void user_enters_new_username_password_and_click_on_signup() {
        homePage.signUpNewUsername("WEftt5OIeUHeytdewqGLKAbuf");
        homePage.signUpNewPassword("IyEHryT8GOwuw5qrWEnguoh");
        homePage.clickOnSignUpButton();
    }
    @Then("successful message appears to user")
    public void successful_message_appears_to_user() {
        String actualResult = homePage.getSign_UpValidation();
        String expectedResult = "Sign up successful.";
        Assert.assertTrue(actualResult.contains(expectedResult));
        homePage.acceptSuccessfulAlert();
    }
//SignUp Existing User (Negative Scenario) (**Bonus**)
    @When("user enters existing username & password and click on signup")
    public void user_enters_existing_username_password_and_click_on_signup(){
        homePage.signUpNewUsername("r");
        homePage.signUpNewPassword("r");
        homePage.clickOnSignUpButton();
    }
    @Then("error message appears to user as an existing user")
    public void error_message_appears_to_user_as_an_existing_user() throws InterruptedException {
        String actualResult = homePage.getSign_UpValidation();
        String expectedResult = "This user already exist.";
        Assert.assertTrue(actualResult.contains(expectedResult));
        homePage.acceptSuccessfulAlert();
    }
}