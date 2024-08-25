package stepDefinition;

import io.cucumber.java.en.Given;
import static pages.HomePage.*;

public class Home {
    @Given("User navigate to the Login page")
    public void user_navigate_to_the_login_page() throws InterruptedException {
        click_hamburger_button();
        click_signIn_link();
    }
    @Given("User navigate to the online products page")
    public void user_navigate_to_the_online_products_page() throws InterruptedException {
        click_hamburger_button();
        click_onlineProducts_link();
    }

}
