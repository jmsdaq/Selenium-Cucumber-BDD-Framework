package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='username']")
    WebElement enterUsername;

    @FindBy(xpath = "//input[@name='password']")
    WebElement enterPassword;

    @FindBy(className = "oxd-input-field-error-message")
    WebElement errorMessage;

    @FindBy(css = "button[type='submit']")
    WebElement loginButton;

    @FindBy(xpath = "//h6[text()='Dashboard']")
    WebElement dashboardElement;

    public String dashboardUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";

    public void navigateToLoginPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); // Update URL as necessary
        wait.until(ExpectedConditions.visibilityOf(enterUsername));
    }
    public void usernameInput(String username){
        enterUsername.sendKeys(username);
    }
    public void passwordInput(String password){
        enterPassword.sendKeys(password);
    }

    public void setLoginButton() {
        loginButton.click();
    }

    public String getErrorMessage(){
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.getText();
    }

    public String getExpectedUrl(){
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        return dashboardUrl;
    }

    public String getDashboardElementText() {
        wait.until(ExpectedConditions.visibilityOf(dashboardElement));
        return dashboardElement.getText();
    }
}