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

    @FindBy(xpath = "//button[normalize-space() = 'Add']")
    WebElement addButton;

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


    public void navigatePIM(){
        waitForElementClickable(pim);
        pim.click();
    }
    public void addEmployeeBtn(){
        waitForElementClickable(addButton);
        addButton.click();
    }

    public void fillEmployeeForm(String firstName, String middleName, String lastName, String emp_ID) {
        waitForElementVisible(firstNameField);
        firstNameField.sendKeys(firstName);

        waitForElementVisible(middleNameField);
        middleNameField.sendKeys(middleName);

        waitForElementVisible(lastNameField);
        lastNameField.sendKeys(lastName);

        waitForElementVisible(employeeId);
        employeeId.sendKeys(emp_ID);
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
