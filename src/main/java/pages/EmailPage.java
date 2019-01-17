package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class EmailPage extends TestBase {
    @FindBy(id = "email")
    private WebElement email_input;
    @FindBy(xpath = "//button[contains(text(),'Continua')]")
    private WebElement continua_button;

    public EmailPage() {
        PageFactory.initElements(driver, this);
    }

    //write in the email text box the email address provided in config.properties file
    public void insertEmail()  {

        email_input.sendKeys(prop.getProperty("email"));
    }

    public PasswordPage clickOnContinueButton() {
        continua_button.click();

        //after clicking the button "Continua", a new page will be displayed --> PasswordPage
        return new PasswordPage();
    }
}