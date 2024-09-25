package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditEmployeePage {
    WebDriver driver;

    // Locators using PageFactory
    @FindBy(id = "employeeList")
    WebElement employeeList;

    @FindBy(id = "btnEdit")
    WebElement editButton;

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "address")
    WebElement addressField;

    @FindBy(id = "btnSave")
    WebElement saveButton;

    @FindBy(id = "btnCancel")
    WebElement cancelButton;

    @FindBy(css = ".message.success")
    WebElement confirmationMessage;

    @FindBy(css = ".message.error")
    WebElement errorMessage;

    // Constructor to initialize PageFactory elements
    public EditEmployeePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Actions
    public void selectEmployee(String employeeName) {
        driver.findElement(By.xpath("//a[text()='" + employeeName + "']")).click();
    }

    public void clickEdit() {
        editButton.click();
    }

    public void enterEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterAddress(String address) {
        addressField.clear();
        addressField.sendKeys(address);
    }

    public void clickSave() {
        saveButton.click();
    }

    public void clickCancel() {
        cancelButton.click();
    }

    public boolean isConfirmationMessageDisplayed() {
        return confirmationMessage.isDisplayed();
    }

    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }
}
