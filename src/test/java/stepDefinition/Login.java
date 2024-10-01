package stepDefinition;

import base.PageContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.plugin.event.Node;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.*;

public class Login {
    private final PageContext context;
    private final LoginPage loginPage;

    public Login(PageContext context) {
        this.context = context;
        this.loginPage = new LoginPage(context);
    }


    @Given("I am on the login page")
    public void i_am_on_the_login_page() throws InterruptedException {
        loginPage.navigateToLoginPage();
    }
    @When("I enter {string} and {string}")
    public void i_enter_and(String username, String password) {
        loginPage.usernameInput(username);
        loginPage.passwordInput(password);
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        loginPage.loginButton();
    }



    @Then("I should be redirected to the dashboard page")
    public void i_should_be_redirected_to_the_dashboard_page() {
         String actualTitle = loginPage.getDashboardElementText(); // Update with your dashboard page title
         String expectedTitle = "Dashboard";
         assertEquals(expectedTitle, actualTitle);

        // Print dashboard element text for verification
        String dashboardText = loginPage.getDashboardElementText();
        System.out.println("Dashboard Text: " + dashboardText);

        // Alternatively, verify the page url
//        String expectedUrl = loginpage.getExpectedUrl();
//        String currentUrl = driver.getCurrentUrl();
//        assertEquals(expectedUrl, currentUrl);

    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String expectedErrorMessage) {
        String actualErrorMessage = loginPage.isInvalidCredentialsErrorDisplayed();
//        assertNotNull(actualErrorMessage, "Error message should not be null");
        assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Then("I should see a message {string}")
    public void i_should_see_a_message(String expectedMessage){
        String actualMessage = loginPage.isEmptyFieldsErrorDisplayed();
        assertEquals(expectedMessage, actualMessage);
    }

}
