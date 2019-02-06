import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(strict = true,
features = {"D:/workspace/BDD Automation Framework/src/main/java/features/Login1.feature"},
plugin = {"json:target/cucumber-parallel/2.json", "html:target/cucumber-parallel/2.html"},
monochrome = true,
tags = {},
glue = { "stepDefinitions" })
public class Login102IT extends AbstractTestNGCucumberTests {
}
