package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import utility.Hooks;


public class Try {

    WebDriver driver;
    HomePage homePage;

    public Try() {
        this.driver = Hooks.getDriver();
        homePage = new HomePage(driver);
    }
    @Given("User navigate to the the hamburger menu")
    public void user_navigate_to_the_the_hamburger_menu() throws InterruptedException {
        Thread.sleep(2000);
        homePage.clickHamburger();
    }
    @When("User clicks on the online products")
    public void user_clicks_on_the_online_products() throws InterruptedException{
        homePage.clickOnlineProd();
    }
    @And("User clicks on formal shoes drop down")
    public void user_clicks_on_formal_shoes_drop_down() throws InterruptedException {
        Thread.sleep(2000);
        homePage.clickFormalShoe();
    }
    @Then("User should be able to view the formal shoe products")
    public void user_should_be_able_to_view_the_formal_shoe_products() throws InterruptedException {
        String productName = homePage.getProductName();
        Assert.assertEquals(productName, "   Classic Cheltenham");

    }
}
