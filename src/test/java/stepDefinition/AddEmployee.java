package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import pages.AddEmployeePage;
import pages.LoginPage;
import utility.Hooks;


public class AddEmployee {
    private WebDriver driver = Hooks.driver;
    private LoginPage loginpage;
    private AddEmployeePage addEmployeePage;

    @Given("I am logged in as a user with permissions to access the PIM menu")
    public void i_am_logged_in_as_a_user_with_permissions_to_access_the_pim_menu() {
        addEmployeePage = new AddEmployeePage(driver);
        loginpage = new LoginPage(driver);
        loginpage.navigateToLoginPage();
        loginpage.setLogin("Admin", "admin123");
    }

    @When("I navigate to the PIM menu")
    public void i_navigate_to_the_pim_menu() {
        addEmployeePage.navigatePIM();
    }

    @When("I click on the add button")
    public void i_click_on_the_add_button() {
        addEmployeePage.addEmployeeBtn();
    }

    @And("I fill in the employee details with firstname {string}")
    public void iFillInTheEmployeeDetailsWithFirstname(String firstName) {
        addEmployeePage.setFirstName(firstName);
    }

    @When("I fill in the employee details with firstname {string}, middlename {string}, lastname {string}, and employee ID {string}")
    public void i_fill_in_the_employee_details(String firstName, String middleName, String lastName, String emp_ID) {
        addEmployeePage.fillEmployeeForm(firstName, middleName, lastName, emp_ID);
    }

    @When("I fill in the employee details with firstname {string}, and employee ID {string}")
    public void i_fill_in_the_employee_details_with_missing_fields(String firstName, String emp_ID) {
        addEmployeePage.fillEmployeeForm(firstName, "", "", emp_ID);
    }

    @When("I submit the form")
    public void i_submit_the_form() {
        addEmployeePage.clickSave();
    }

    @Then("I should see a confirmation message that the employee was successfully added")
    public void i_should_see_a_confirmation_message_that_the_employee_was_successfully_added() {
        String actualMessage = addEmployeePage.getConfirmationMessage();
        assertEquals("Success", actualMessage); // Adjust the expected message as necessary
    }

    @Then("I should see an error message indicating the missing required fields")
    public void i_should_see_an_error_message_indicating_missing_fields() {
        String errorMessage = addEmployeePage.getErrorMessage();
        assertTrue(errorMessage.contains("Required fields cannot be empty")); // Adjust as per the actual error message
    }

    @Given("I have already added an employee with firstname {string}, middlename {string}, lastname {string}, and employee ID {string}")
    public void i_have_already_added_an_employee(String firstName, String middleName, String lastName, String emp_ID) {
        addEmployeePage.fillEmployeeForm(firstName, middleName, lastName, emp_ID);
    }

    @Then("I should see an error message indicating a duplicate employee ID")
    public void i_should_see_an_error_message_indicating_duplicate_employee_id() {
        String errorMessage = addEmployeePage.getErrorMessage();
        assertTrue(errorMessage.contains("Employee Id already exists")); // Adjust as per the actual error message
    }

}