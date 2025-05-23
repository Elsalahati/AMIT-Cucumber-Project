package stepsdef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Hooks {
    public  static WebDriver chromeDriver;

    @Before
    public void browserDriverSetup(){
        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://demoblaze.com/");
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }
    @After
    public void closeBrowser(){
        chromeDriver.quit();
    }
    public static WebDriver getDriverForCucmber(){
        return chromeDriver;
    }
}
