package pages;

import org.openqa.selenium.By;
import utility.BrowserDriver;

import static org.junit.Assert.assertEquals;

public class OnlineProductsPage extends BrowserDriver {
    public static String formalshoes_dropdown_class = "formalshoedropdown";
    public static String formalshoes_webtable = "/html/body/div[2]/table";
    public static String formalshoes_webtable_tr = "/html/body/div[2]/table/tbody/tr[1]/td[1]";

    public static void click_fs_dropdown() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.className(formalshoes_dropdown_class)).click();
    }
    public static void getText_formalshoes_firstvalue(){
        String actualtr1_fs = driver.findElement(By.xpath(formalshoes_webtable_tr)).getText();
        assertEquals("   Classic Cheltenham", actualtr1_fs);
    }
}
