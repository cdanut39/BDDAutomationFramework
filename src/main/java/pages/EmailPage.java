package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class EmailPage extends GeneralActions {
    @FindBy(id = "email")
    private WebElement email_input;
    @FindBy(xpath = "//button[contains(text(),'Continua')]")
    private WebElement continua_button;

    public EmailPage() {
        PageFactory.initElements(driver, this);
    }

    public void insertEmail() {
        sendKeysToWebElement(email_input, prop.getProperty("EMAIL"));
    }

    public PasswordPage clickOnContinueButton(){
        waitAndClickElement(continua_button);
        return new PasswordPage();
    }
}
