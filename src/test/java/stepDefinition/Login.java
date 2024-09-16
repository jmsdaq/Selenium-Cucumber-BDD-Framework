package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.plugin.event.Node;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utility.Hooks;

import static org.junit.Assert.*;

public class Login {

//    WebDriver driver;
    private WebDriver driver = Hooks.driver;
    private LoginPage loginpage;
//    LoginPage loginpage;

//    public Login() {
//        this.driver = Hooks.getDriver();
//        private LoginPage loginPage;
//    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() throws InterruptedException{
        loginpage = new LoginPage(driver);
        Thread.sleep(2000);
        loginpage.navigateToLoginPage();
    }
    @When("I enter {string} and {string}")
    public void i_enter_and(String username, String password) {
        loginpage.usernameInput(username);
        loginpage.passwordInput(password);
    }


    @When("I click the login button")
    public void i_click_the_login_button() {
        loginpage.setLoginButton();
    }

    @Then("I should be redirected to the dashboard page")
    public void i_should_be_redirected_to_the_dashboard_page() throws InterruptedException {
         String actualTitle = loginpage.getDashboardElementText(); // Update with your dashboard page title
         String expectedTitle = "Dashboard";
         assertEquals(expectedTitle, actualTitle);

        // Print dashboard element text for verification
        String dashboardText = loginpage.getDashboardElementText();
        System.out.println("Dashboard Text: " + dashboardText);

        // Alternatively, verify the page url
//        String expectedUrl = loginpage.getExpectedUrl();
//        String currentUrl = driver.getCurrentUrl();
//        assertEquals(expectedUrl, currentUrl);

    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String expectedErrorMessage) {
        String actualErrorMessage = loginpage.isInvalidCredentialsErrorDisplayed();
//        assertNotNull(actualErrorMessage, "Error message should not be null");
        assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Then("I should see a message {string}")
    public void i_should_see_a_message(String expectedMessage){
        String actualMessage = loginpage.isEmptyFieldsErrorDisplayed();
        assertEquals(expectedMessage, actualMessage);
    }

}
