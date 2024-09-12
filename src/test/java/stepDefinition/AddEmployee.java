package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import pages.AddEmployeePage;

public class AddEmployee {
    private AddEmployeePage addEmployeePage;

    public AddEmployee(AddEmployeePage addEmployeePage) {
        this.addEmployeePage = addEmployeePage;
    }

    @Given("I am on the {string} page")
    public void i_am_on_the_page(String pageName) {
        if (pageName.equals("Add Employee")) {
            addEmployeePage.navigateToAddEmployeePage();
        }
    }

    @When("I enter valid details {string} {string} {string}")
    public void i_enter_valid_details(String firstName, String lastName, String email) {
        addEmployeePage.enterFirstName(firstName);
        addEmployeePage.enterLastName(lastName);
        addEmployeePage.enterEmail(email);
    }

    @When("I click the {string} button")
    public void i_click_the_button(String buttonName) {
        if (buttonName.equals("Save")) {
            addEmployeePage.clickSave();
        }
    }

    @Then("I should see a confirmation message {string}")
    public void i_should_see_a_confirmation_message(String message) {
        String actualMessage = addEmployeePage.getConfirmationMessage();
        assertEquals(message, actualMessage);
    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String errorMessage) {
        String actualErrorMessage = addEmployeePage.getErrorMessage();
        assertEquals(errorMessage, actualErrorMessage);
    }
}
