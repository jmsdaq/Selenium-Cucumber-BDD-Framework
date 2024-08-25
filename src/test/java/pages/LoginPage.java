package pages;

import org.openqa.selenium.By;
import utility.BrowserDriver;

public class LoginPage extends BrowserDriver {

    public static String usernameId = "usr";
    public static String passwordId = "pwd";
    public static String loginButton = "//*[@id=\"second_form\"]/input";
    public static String registerButton = "NewRegistration";


    public static void sendkeys_username() throws InterruptedException{
        driver.findElement(By.id(usernameId)).sendKeys("ducksyde@gmail.com");
    }
    public static void sendkeys_password() throws InterruptedException{
        driver.findElement(By.id(passwordId)).sendKeys("P@assword!");
    }
    public static void click_login(){
        driver.findElement(By.xpath(loginButton)).click();
    }
    public static void click_registration(){
        driver.findElement(By.id(registerButton)).click();
    }

//    public static void click_signIn_link () throws InterruptedException {
//        Thread.sleep(2000);
//        driver.findElement(By.xpath(signIn_link_xpath)).click();
//    }
}

