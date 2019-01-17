package base;

import config.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    //Objects declaration
    public static WebDriver driver;
    public static Properties prop;
    public static WebDriverWait wait;

    //Constructor of the class. The properties file is
    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream(Constants.PROPERTIES_PATH);
            prop.load(fis);
        } catch (
                FileNotFoundException e) {
            System.out.println("The properties file couldn't be found in the specified location ");
        } catch (
                IOException e) {
            System.out.println("Couldn't read information from specified properties file");
        }
    }


    public static void intialization() {
        String browserName = prop.getProperty("browser");

        //choose the browser for tests execution
        try {
            switch (browserName) {
                case "chrome":
                    if (driver == null) {
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
                        break;
                    }
                case "firefox":
                    if (driver == null) {
                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver();
                        break;
                    }
                case "ie":
                    if (driver == null) {
                        WebDriverManager.iedriver().setup();
                        driver = new InternetExplorerDriver();
                        break;
                    }
            }
        } catch (Exception e) {
            System.out.println("Unable to load the browser");
        }
        //instantiate an object of explicit wait type
        wait = new WebDriverWait(driver, 10);

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);

        //launch the browser and navigate to the address specified in properties file
        driver.get(prop.getProperty("url"));
    }
}
