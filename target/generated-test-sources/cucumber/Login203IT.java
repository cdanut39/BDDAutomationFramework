import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(strict = true,
features = {"D:/workspace/BDD Automation Framework/src/main/java/features/Login2.feature"},
plugin = {"json:target/cucumber-parallel/3.json", "html:target/cucumber-parallel/3.html"},
monochrome = true,
tags = {},
glue = { "stepDefinitions" })
public class Login203IT extends AbstractTestNGCucumberTests {
}
