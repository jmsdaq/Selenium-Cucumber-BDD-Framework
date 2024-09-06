package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    Webdriver driver;

    public HomePage(Webdriver driver) {
        this.driver = driver;
        PageFactory.initElements(drive, this);
    }

    @FindBy(xpath = "//*[@id=\"menuToggle\"]/input")
    WebElement hamburger_menu;

    @FindBy(xpath = "//*[@id=\"menu\"]/a[2]/li")
    WebElement signIn_xpath;

    @FindBy(linkText = "Online Products")
    WebElement onlineProduct_lt;

    public void clickHamburger() {
        hamburger_menu.click();
    }

    public void clickSignIn() {
        signIn_xpath.click();
    }

    public void clickOnlineProd() {
        onlineProduct_lt.click();
    }

}
