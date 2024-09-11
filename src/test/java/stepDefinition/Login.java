package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utility.Hooks;

import static pages.LoginPage.*;

public class Login {

    WebDriver driver;
    LoginPage loginpage;

    public Login() {
        this.driver = Hooks.getDriver();
        loginpage = new LoginPage(driver);
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        loginpage.passwordInput("Admin");
        loginpage.passwordInput("admin123");
        loginpage.setLoginButton();
    }
    @When("I enter {string} and {string}")
    public void i_enter_and(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I click the login button")
    public void i_click_the_login_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("I should be redirected to the dashboard page")
    public void i_should_be_redirected_to_the_dashboard_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
