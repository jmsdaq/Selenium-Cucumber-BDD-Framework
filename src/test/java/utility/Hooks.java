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

package utility;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

