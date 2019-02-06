import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(strict = true,
features = {"D:/workspace/BDD Automation Framework/src/main/java/features/Login3.feature"},
plugin = {"json:target/cucumber-parallel/4.json", "html:target/cucumber-parallel/4.html"},
monochrome = true,
tags = {},
glue = { "stepDefinitions" })
public class Login304IT extends AbstractTestNGCucumberTests {
}
