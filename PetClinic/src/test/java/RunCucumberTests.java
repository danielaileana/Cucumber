import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(
        features="src/test/resources",
        glue="stepdefs",
        plugin="{pretty}"
        )
public class RunCucumberTests extends AbstractTestNGCucumberTests {





}
