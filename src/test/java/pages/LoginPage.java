package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[placeholder='Username']")
    WebElement username;

    @FindBy(css = "input[placeholder='Password']")
    WebElement password;

    @FindBy(css = "button[type='submit']")
    WebElement loginButton;

    public void usernameInput(String username){
        loginButton.sendKeys(username);
    }
    public void passwordInput(String password){
        loginButton.sendKeys(password);
    }

    public void setLoginButton() {
        loginButton.click();
    }
}