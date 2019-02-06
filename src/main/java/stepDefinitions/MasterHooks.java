package stepDefinitions;

import base.TestBase;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.log4j.Logger;

import static utils.TestUtil.takeScreenShot;

public class MasterHooks extends TestBase {
    static Logger log = Logger.getLogger(MasterHooks.class);

    @Before()
    public void setup(Scenario scenario) {
        String a = scenario.getName();
        //call the static method from parent class(TestBase) to open the browser and to navigate to application
        TestBase.intialization();
        log.info("====================Start to run test scenario: \"" + scenario.getName() + "\"====================");
    }

    @After()
    public void takeScreenshotOnFailure(Scenario scenario) {
        log.info("\""+scenario.getName() + "\" ----> " + scenario.getStatus().toUpperCase());
        //check if the scenario got failed. If Yes, call the method for taking screenshot
        if (scenario.isFailed()) {
            takeScreenShot(scenario);
            log.info("Screenshot taken for test scenario: \"" + scenario.getName() + "\"");
        }
        driver.quit();
    }
}