package pages;

import base.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static java.util.concurrent.TimeUnit.SECONDS;

public class GeneralActions extends TestBase {

    static Logger log = Logger.getLogger(GeneralActions.class);
    protected WebDriverWait wait;
    protected JavascriptExecutor js;

    public GeneralActions() {
        this.wait = new WebDriverWait(driver, 15);
        js = ((JavascriptExecutor) driver);
    }

    /**********************************************************************************
     **CLICK METHODS
     **********************************************************************************/
    public void waitAndClickElement(WebElement element) {
        driver.manage().timeouts().implicitlyWait(0, SECONDS);
        String locator = getLocator(element);
        try {
            log.info("Trying to find Element by-" + locator);
            this.WaitUntilWebElementIsVisible(element);
            log.info("Found element by-" + locator);
            log.info("Trying to click on element found by-" + locator);
            this.wait.until(ExpectedConditions.elementToBeClickable(element)).click();
            log.info("Successfully clicked on the web element found by-" + locator);
        } catch (Exception e) {
            log.error("Unable to wait and click on the element using the WebElement: " + element.toString());
            Assert.fail("Unable to wait and click on the web element, using locator: " + "<" + e.getMessage() + ">");
        }

    }

    public void waitAndClickElementsUsingByLocator(By by) {
        driver.manage().timeouts().implicitlyWait(0, SECONDS);
        try {
            this.wait.until(ExpectedConditions.elementToBeClickable(by)).click();
            log.info("Successfully clicked on the element using by locator: " + "<" + by.toString() + ">");
        } catch (Exception e) {
            log.error("Unable to wait and click on the element using the By locator, Exception: " + e.getMessage());
            Assert.fail("Unable to wait and click on the element using the By locator, element: " + "<" + by.toString() + ">");
        }

    }


    /**********************************************************************************
     **SEND KEYS METHODS /
     **********************************************************************************/
    public void sendKeysToWebElement(WebElement element, String textToSend) {
        driver.manage().timeouts().implicitlyWait(0, SECONDS);
        try {

            this.WaitUntilWebElementIsVisible(element);
            log.info("Clearing text from element using locator by-" + getLocator(element));
            element.clear();
            log.info("Successfully cleared text from locator by-" + getLocator(element) + " \t,before sending the keys");
            log.info("Trying to send keys: \""+textToSend+"\" to element using by-" + getLocator(element));
            element.sendKeys(textToSend);
            log.info("Successfully sent the following keys: '" + textToSend + "' to element-" + getLocator(element));
        } catch (Exception e) {
            log.error("Unable to locate web element -: " + element.toString() + " and send the following keys: " + textToSend);
            Assert.fail("Unable to send keys to web element, Exception: " + e.getMessage());
        }
    }


    /**********************************************************************************
     **ACTION METHODS
     **********************************************************************************/
    public void actionMoveAndClick(WebElement element) {
        driver.manage().timeouts().implicitlyWait(0, SECONDS);
        String locator = getLocator(element);
        Actions action = new Actions(driver);
        try {
            this.wait.until(ExpectedConditions.elementToBeClickable(element));
            action.moveToElement(element).click().build().perform();
            log.info("Successful actions- moved and clicked on the WebElement, using locator: " + locator);
        } catch (Exception e) {
            log.error("Unable to Action Move and Click on the WebElement, using locator: " + locator);
            Assert.fail("Unable to Action Move and Click on the WebElement, Exception: " + e.getMessage());
        }
    }

    public void actionMove(WebElement element) {
        String locator = getLocator(element);
        Actions action = new Actions(driver);
        try {
            this.wait.until(ExpectedConditions.elementToBeClickable(element)).isEnabled();
            action.moveToElement(element).build().perform();
            log.info("Successful actions- moved and clicked on the WebElement, using locator: " + locator);
        } catch (Exception e) {
            log.error("Unable to Action Move and Click on the WebElement, using locator: " + locator);
            Assert.fail("Unable to Action Move and Click on the WebElement, Exception: " + e.getMessage());
        }
    }


    /**********************************************************************************
     **WAIT METHODS
     **********************************************************************************/
    public boolean WaitUntilWebElementIsVisible(WebElement element) {
        try {
            log.info("Waiting for visibility of web element using locator-" + getLocator(element));
            this.wait.until(ExpectedConditions.visibilityOf(element));
            log.info("Web element is visible using locator-" + getLocator(element));
            return true;
        } catch (Exception e) {
            log.error("WebElement is NOT visible, using locator->" + element.toString().substring(41));
            Assert.fail("WebElement is NOT visible, Exception: " + e.getMessage());
            return false;
        }
    }

    public boolean WaitUntilWebElementIsVisibleUsingByLocator(By element) {
        try {
            this.wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            log.info("Element is visible using By locator: " + "<" + element.toString() + ">");
            return true;
        } catch (Exception e) {
            log.error("WebElement is NOT visible, using By locator: " + "<" + element.toString() + ">");
            Assert.fail("WebElement is NOT visible, Exception: " + e.getMessage());
            return false;
        }
    }

    public boolean isElementClickable(WebElement element) {
        try {
            this.wait.until(ExpectedConditions.elementToBeClickable(element));
            log.info("WebElement is clickable using locator: " + "<" + element.toString() + ">");
            return true;
        } catch (Exception e) {
            log.error("WebElement is NOT clickable using locator: " + "<" + element.toString() + ">");
            return false;
        }
    }


    /**********************************************************************************
     **JS METHODS & JS SCROLL
     **********************************************************************************/
    public void scrollToElementByWebElementLocator(WebElement element) {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(element)).isEnabled();
            js.executeScript("arguments[0].scrollIntoView();", element);
//            js.executeScript("window.scrollBy(0, -400)");
            log.info("Succesfully scrolled to the WebElement, using locator: " + "<" + element.toString() + ">");
        } catch (Exception e) {
            log.error("Unable to scroll to the WebElement, using locator: " + "<" + element.toString() + ">");
            Assert.fail("Unable to scroll to the WebElement, Exception: " + e.getMessage());
        }
    }

    public void jsClick(WebElement element) {
        js.executeScript("arguments[0].click();", element);
    }


    /**********************************************************************************
     **GET TEXT
     **********************************************************************************/
    public String getTextFromElement(WebElement element) {
        try {
            this.WaitUntilWebElementIsVisible(element);
            String text = element.getText();
            log.info("The following text was extracted: " + element.getText() + "from WebElement" + getLocator(element));
            return text;
        } catch (Exception e) {
            log.error("Unable to get text from the WebElement, using locator: " + "<" + element.toString() + ">");
            return null;
        }
    }


    public String getTextUsingGetAttributeValue(WebElement element) {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(element));
            return element.getAttribute("value");
        } catch (Exception e) {
            log.error("Unable to get text(using getAttribute- value) from the WebElement, using locator: " + "<" + element.toString() + ">");
            return null;
        }
    }

    public String getTextUsingGetAttributeTextContent(WebElement element) {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(element));
            return element.getAttribute("textContent");
        } catch (Exception e) {
            log.error("Unable to get text (using getAttribute-textContent) from the WebElement, using locator: " + "<" + element.toString() + ">");
            return null;
        }
    }

    public String getTextUsingGetAttributeInnerHTML(WebElement element) {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(element));
            return element.getAttribute("innerHTML");
        } catch (Exception e) {
            log.error("Unable to get text (using getAttribute-innerHTML) from the WebElement, using locator: " + "<" + element.toString() + ">");
            return null;
        }
    }

    /**********************************************************************************
     **Non Selenium Methods
     **********************************************************************************/
    private static String removeLastChar(String str) {
        return str.substring(0, str.length() - 1);
    }

    public static String getLocator(WebElement element) {
        int index = element.toString().lastIndexOf(">");
        removeLastChar(element.toString());
        return removeLastChar(element.toString()).substring(index);
    }
}
