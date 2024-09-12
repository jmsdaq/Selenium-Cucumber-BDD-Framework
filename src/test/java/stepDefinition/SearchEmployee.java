package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import pages.EmployeeListPage;

public class SearchEmployee {
    private EmployeeListPage employeeListPage;

    public SearchEmployee(EmployeeListPage employeeListPage) {
        this.employeeListPage = employeeListPage;
    }

    @Given("I am on the {string} page")
    public void i_am_on_the_page(String pageName) {
        if (pageName.equals("Employee List")) {
            employeeListPage.navigateToEmployeeListPage();
        }
    }

    @When("I search for employee with {string}")
    public void i_search_for_employee_with(String query) {
        employeeListPage.searchForEmployee(query);
    }

    @Then("I should see {string}")
    public void i_should_see(String expectedResult) {
        String actualResult = employeeListPage.getSearchResult();
        assertTrue(actualResult.contains(expectedResult));
    }
}
