package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddEmployeePage extends BasePage{

    public AddEmployeePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a")
    WebElement pim;

    @FindBy(xpath = "//button[normalize-space() = 'Add']\n")
    WebDriver addButton;

    @FindBy(xpath = "//input[@name='firstName']")
    WebElement firstNameField;

    @FindBy(xpath = "//input[@name='middleName']")
    WebElement middleNameField;

    @FindBy(xpath = "//input[@name='lastName']")
    WebElement lastNameField;

    @FindBy(xpath = "//input[@fdprocessedid='3ixx6']")
    WebElement employeeId;

    @FindBy(xpath = "//span[normalize-space(text()) = 'Employee Id already exists']")
    WebElement duplicateEmployeeIdError;

    @FindBy(css = "button.oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space")
    WebElement saveButton;

    @FindBy(xpath = "//div[@aria-live='assertive' and contains(@class, 'oxd-toast')]")
    WebElement confirmationMessage;

    @FindBy(css = "span.oxd-text.oxd-text--span.oxd-input-field-error-message.oxd-input-group__message\n")
    WebElement errorMessage;


    public void enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void clickSave() {
        saveButton.click();
    }

    public String getConfirmationMessage() {
        return confirmationMessage.getText();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
