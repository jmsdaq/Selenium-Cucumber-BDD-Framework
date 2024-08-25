package stepDefinition;

import io.cucumber.java.en.Then;
import static pages.LoggedInPage.*;

public class LoggedIn {
    @Then("User should be able to view the product category page")
    public void user_should_be_able_to_view_the_product_category_page() throws InterruptedException{
        visibility_productcat_formalshoes();
        visibility_productcat_sportsshoes();
        visibility_product_sneakershoes();
    }
}
