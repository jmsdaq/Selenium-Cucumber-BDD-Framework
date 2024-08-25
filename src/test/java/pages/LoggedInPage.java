package pages;

import org.openqa.selenium.By;
import utility.BrowserDriver;

import static org.junit.Assert.assertEquals;

public class LoggedInPage extends BrowserDriver {
    public static String productcat_formalshoes = "//*[text()='Formal Shoes']";
    public static String productcat_sportsshoes = "//*[text()='Sports']";
    public static String productcat_sneakershoes = "//*[text()='Sneakers']";

    public static void visibility_productcat_formalshoes() throws InterruptedException{
        String actualproductcat_fs  = driver.findElement(By.xpath(productcat_formalshoes)).getText();
        assertEquals("Formal Shoes", actualproductcat_fs);
    }
    public static void visibility_productcat_sportsshoes() throws InterruptedException{
        String actualproductcat_ss  = driver.findElement(By.xpath(productcat_sportsshoes)).getText();
        assertEquals("Sports", actualproductcat_ss);

    }
    public static void visibility_product_sneakershoes() throws InterruptedException{
        String actualproductcat_sn  = driver.findElement(By.xpath(productcat_sneakershoes)).getText();
        assertEquals("Sneakers", actualproductcat_sn);
    }
}
