package stepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static pages.OnlineProductsPage.*;

public class OnlineProducts {
    @When("User clicks on formal shoes drop down")
    public void user_clicks_on_formal_shoes_drop_down() throws InterruptedException{
        click_fs_dropdown();
    }

    @Then("User should be able to view the products")
    public void user_should_be_able_to_view_the_products() throws InterruptedException{
        getText_formalshoes_firstvalue();
    }
}
