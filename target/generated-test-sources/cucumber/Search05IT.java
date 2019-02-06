import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(strict = true,
features = {"D:/workspace/BDD Automation Framework/src/main/java/features/Search.feature"},
plugin = {"json:target/cucumber-parallel/5.json", "html:target/cucumber-parallel/5.html"},
monochrome = true,
tags = {},
glue = { "stepDefinitions" })
public class Search05IT extends AbstractTestNGCucumberTests {
}
