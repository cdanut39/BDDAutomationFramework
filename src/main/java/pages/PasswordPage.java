package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordPage extends TestBase {
    @FindBy(id = "password")
    private WebElement password_input;
    @FindBy(xpath = "//button[contains(text(),'Continua')]")
    private WebElement continua_button;

    public PasswordPage() {
        PageFactory.initElements(driver, this);
    }

    public void insertPassword()  {
        password_input.sendKeys(prop.getProperty("password"));
    }

    public HomePage clickOnContinuaButton() {
        continua_button.click();
        return new HomePage();
    }
}