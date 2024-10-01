//package utility;
//
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import org.openqa.selenium.WebDriver;
//
//
//public class Hooks {
//    private static WebDriver driver;
////    private static final String BASE_URL = "https://anupdamoda.github.io/AceOnlineShoePortal/index.html";
//
//    @Before
//    public void setUp() {
//        driver = BrowserDriver.getDriver();
//        driver.manage().window().maximize();
////        driver.get(BASE_URL); // Navigate to the website
//    }
//
//    @After
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//
//    public static WebDriver getDriver() {
//        return driver;
//    }
//
//}

//package utility;
//
//import io.cucumber.java.Before;
//import io.cucumber.java.After;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class Hooks {
//    public static WebDriver driver;
//
//    @Before
//    public void setUp() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//    }
//
//    @After
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//}


///////////////////////////////////////////////
package utility;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PageContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    private PageContext context;

    public Hooks(PageContext context) {
        this.context = context;
    }

    @Before(order = 1)
    public void beforeScenario(Scenario scenario) {
        System.out.println("Im in beforeScenario");
        RemoteWebDriver driver = new ChromeDriver();
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        context.setDriver(driver);
        context.setWait(wait);
        Options manage =context.getDriver().manage();
        manage.timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        manage.window().maximize();

    }

    @After(order = 1)
    public void afterScenario(Scenario scenario) {
        boolean failed = scenario.isFailed();
        System.out.println("is Failed? "+failed);
        if (scenario.isFailed()) {
            byte[] screenshot = context.getDriver().getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot on Failure");
        }
        System.out.println("Captured screenshot for failed scenario: " + scenario.getName());
        context.getDriver().quit();
    }
}


