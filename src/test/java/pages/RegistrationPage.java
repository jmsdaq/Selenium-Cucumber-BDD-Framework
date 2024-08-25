package pages;

import org.openqa.selenium.By;
import utility.BrowserDriver;

import static org.junit.Assert.assertEquals;

public class RegistrationPage extends BrowserDriver {
    public static String user_registration_title = "/html/body/center/h1";

    public static void visibility_user_registration_page() throws InterruptedException{
        String actualpage  = driver.findElement(By.xpath(user_registration_title)).getText();
        assertEquals("User Registration Page", actualpage);
    }
    
}
