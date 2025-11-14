package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        glue = {"stepdefs"},
        features = "src/test/resources/shop",
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true
)
@Test(groups = "cucumber", threadPoolSize = 3, invocationCount = 1)
public class RunCucumberTest extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(name = "scenarios", parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}