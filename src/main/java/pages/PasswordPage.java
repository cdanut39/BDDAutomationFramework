package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordPage extends GeneralActions {
    @FindBy(id = "password")
    private WebElement password_input;
    @FindBy(xpath = "//button[contains(text(),'Continua')]")
    private WebElement continua_button;

    public PasswordPage() {
        PageFactory.initElements(driver, this);
    }

    public void insertPassword() throws Exception {
        sendKeysToWebElement(password_input, prop.getProperty("PASSWORD"));
    }

    public HomePage clickOnContinuaButton() {
        continua_button.click();
        return new HomePage();
    }
}
