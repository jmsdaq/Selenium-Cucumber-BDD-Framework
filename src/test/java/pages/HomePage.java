package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"menuToggle\"]/input")
    WebElement hamburger_menu;

    @FindBy(xpath = "//*[@id=\"menu\"]/a[3]/li")
    WebElement onlineProduct_lt;

    @FindBy(className = "formalshoedropdown")
    WebElement formalShoe;

    @FindBy(xpath = "/html/body/div[2]/table/tbody/tr[1]/td[1]")
    WebElement productName;

    public void clickHamburger() {
        hamburger_menu.click();
    }

    public void clickOnlineProd() throws InterruptedException {
        Thread.sleep(2000);
        onlineProduct_lt.click();
    }

    public void clickFormalShoe() throws InterruptedException{
        formalShoe.click();
    }

    public String getProductName() throws InterruptedException{
        return productName.getText();
    }

}
