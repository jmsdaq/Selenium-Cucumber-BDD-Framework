package stepDefinition;

import io.cucumber.java.en.Then;
import static pages.RegistrationPage.visibility_user_registration_page;

public class Registration {
    @Then("User should be able to view the Registration page")
    public void user_should_be_able_to_view_the_registration_page() throws InterruptedException{
        visibility_user_registration_page();
    }
}
