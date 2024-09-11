package utility;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;


public class Hooks {
    private static WebDriver driver;
    private static final String BASE_URL = "https://anupdamoda.github.io/AceOnlineShoePortal/index.html";

    @Before
    public void setUp() {
        driver = BrowserDriver.getDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL); // Navigate to the website
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

}
