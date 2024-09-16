package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;

public class LoginPage extends BasePage{
//    WebDriver driver;
//    WebDriverWait wait;
//
//    public LoginPage(WebDriver driver) {
//        this.driver = driver;
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        PageFactory.initElements(driver, this);
//    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='username']")
    WebElement enterUsername;

    @FindBy(xpath = "//input[@name='password']")
    WebElement enterPassword;

    @FindBy(css = ".oxd-input-field-error-message")  // Correct compound class selector
    WebElement emptyFieldsError;

    @FindBy(css = ".oxd-text.oxd-text--p.oxd-alert-content-text")  // Correct compound class selector
    WebElement invalidCredentialsError;

    @FindBy(css = "button[type='submit']")
    WebElement loginButton;

    @FindBy(xpath = "//h6[text()='Dashboard']")
    WebElement dashboardElement;

    public String dashboardUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";

    public void navigateToLoginPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); // Update URL as necessary
    }
    public void usernameInput(String username){
        waitForElementVisible(enterUsername);
        enterUsername.sendKeys(username);
    }
    public void passwordInput(String password){
        waitForElementVisible(enterPassword);
        enterPassword.sendKeys(password);
    }

    public void setLoginButton() {
        waitForElementClickable(loginButton);
        loginButton.click();
    }

//    public String isEmptyFieldsErrorDisplayed(){
//        return emptyFieldsError.getText();
//    }
//
//    public String isInvalidCredentialsErrorDisplayed(){
//        return invalidCredentialsError.getText();
//    }
//    public boolean isEmptyFieldsErrorDisplayed() {
//        return emptyFieldsError.isDisplayed();
//    }
//
//    public boolean isInvalidCredentialsErrorDisplayed() {
//        return invalidCredentialsError.isDisplayed();
//    }
//
//    public String getErrorMessage() {
//        if (isEmptyFieldsErrorDisplayed()) {
//            return emptyFieldsError.getText();
//        } else if (isInvalidCredentialsErrorDisplayed()) {
//            return invalidCredentialsError.getText();
//        } else {
//            return null;
//        }
//    }
    public String isInvalidCredentialsErrorDisplayed(){
        waitForElementVisible(invalidCredentialsError);
        return invalidCredentialsError.getText();
    }

    public String isEmptyFieldsErrorDisplayed(){
        waitForElementVisible(emptyFieldsError);
        return emptyFieldsError.getText();
    }

//    public String getExpectedUrl(){
//        waitForElementVisible(loginButton);
//        return dashboardUrl;
//    }

    public String getDashboardElementText() {
//        wait.until(ExpectedConditions.visibilityOf(dashboardElement));
        waitForElementVisible(dashboardElement);
        return dashboardElement.getText();
    }
}