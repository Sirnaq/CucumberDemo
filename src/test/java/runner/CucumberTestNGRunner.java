package runner;

import io.cucumber.core.cli.Main;
import org.testng.annotations.Test;

@Test
public class CucumberTestNGRunner {

    @Test
    public void runCucumber() throws Exception {
        String[] args = {
                "--glue", "stepdefs",
                "--plugin", "pretty",
                "--plugin", "html:target/cucumber-reports.html",
                "--plugin", "json:target/cucumber-reports.json",
                "classpath:shop"
        };

        byte exitCode = Main.run(
                args,
                Thread.currentThread().getContextClassLoader()
        );

        if (exitCode != 0) {
            throw new AssertionError("Cucumber failed with exit code: " + exitCode);
        }
    }
}