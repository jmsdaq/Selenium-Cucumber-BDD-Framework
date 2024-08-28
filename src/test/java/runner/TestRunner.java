package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = {"stepDefinition", "utility"},
        plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class TestRunner{

}
