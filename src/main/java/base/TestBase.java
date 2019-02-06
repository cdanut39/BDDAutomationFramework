package base;

import config.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebEventListener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    //create log object to trace actions performed during execution
    static Logger log = Logger.getLogger(TestBase.class);
    //Objects declaration
    public static WebDriver driver;
    public static Properties prop;
    public static WebDriverWait wait;
    public static EventFiringWebDriver e_driver;
    public static WebEventListener webEventListener;

    //Constructor of the class. The properties file is loaded
    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream(Constants.PROPERTIES_PATH);
            prop.load(fis);
        } catch (
                FileNotFoundException e) {
            log.error("The properties file couldn't be found in the specified location");
        } catch (
                IOException e) {
            log.error("Couldn't read information from specified properties file");
        }
    }

    public static void intialization() {
        log.info("*******************************************************************************************");
        String browserName = prop.getProperty("BROWSER");

        if (prop.getProperty("HEADLESS").equalsIgnoreCase("yes")) {
            //choose the browser for tests execution
            getBrowserHeadlessMode(browserName);
            log.info(prop.getProperty("BROWSER").toUpperCase() + " browser in HEADLESS mode is launched!");
        } else if (prop.getProperty("HEADLESS").equalsIgnoreCase("no")) {
            getBrowserNormalMode(browserName);
            log.info(prop.getProperty("BROWSER").toUpperCase() + " browser is launched!");
        } else {
            log.error("Set a valid value for HEADLESS property");
        }
        setDriverPreferences();
        //launch the browser and navigate to the address specified in properties file
        setEnvironment(prop.getProperty("ENVIRONMENT"));
    }

    private static WebDriver getBrowserHeadlessMode(String browserName) {
        try {
            switch (browserName.toUpperCase()) {
                case "CHROME":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(getChromeOptions());
                    break;

                case "FIREFOX":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(getFireFoxOptions());
                    break;
                default:
                    log.error("Unable to load the browser in HEADLESS mode");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }

    private static WebDriver getBrowserNormalMode(String browserName) {
        try {
            switch (browserName.toUpperCase()) {
                case "CHROME":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "FIREFOX":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "IE":

                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                default:
                    log.error("Unable to load the browser in NORMAL mode");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }

    private static void setDriverPreferences() {
        //instantiate an object of explicit wait type
        wait = new WebDriverWait(driver, 10);

        e_driver = new EventFiringWebDriver(driver);
        // Now create object of webEventListener to register it with EventFiringWebDriver
        webEventListener = new WebEventListener();
        e_driver.register(webEventListener);
        driver = e_driver;

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
    }

    private static void setEnvironment(String environment) {
        if (environment.equals("production")) {
            driver.get(prop.getProperty("URL_PROD"));
        } else if (environment.equals("QA")) {
            driver.get(prop.getProperty("URL_QA"));
        }
    }

    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        return options;
    }

    private static FirefoxOptions getFireFoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
        return options;
    }

}
