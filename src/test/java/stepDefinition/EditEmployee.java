package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditEmployee {
    @Given("I am on the Employee List page")
    public void i_am_on_the_employee_list_page() {
        // code to navigate to Employee List
    }

    @When("I select an employee")
    public void i_select_an_employee() {
        // code to select an employee
    }

    @When("I click the Edit button")
    public void i_click_the_edit_button() {
        // code to click edit button
    }

    @When("I update the personal information")
    public void i_update_personal_information() {
        // code to update information
    }

    @When("I click the save button")
    public void i_click_the_save_button() {
        // code to click save button
    }

    @Then("I should see a confirmation message {string}")
    public void i_should_see_confirmation_message(String message) {
        // code to verify confirmation message
    }

    @When("I update the email to {string}")
    public void i_update_email(String email) {
        // code to update email
    }

    @Then("I should see an error message {string}")
    public void i_should_see_error_message(String message) {
        // code to verify error message
    }

    @When("I click the Cancel button")
    public void i_click_the_cancel_button() {
        // code to click cancel button
    }

    @Then("I should be redirected back to the Employee List page")
    public void i_should_be_redirected_to_employee_list() {
        // code to verify redirection
    }

}

