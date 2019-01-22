package pages;


import cucumber.api.DataTable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DefaultPage extends GeneralActions {
    @FindBy(xpath = "//span[text()='Contul meu ']")
    private WebElement contulMeu_button;
    @FindBy(xpath = "//a[text()='Intra in cont']")
    private WebElement intraInCont_button;
    @FindBy(xpath = "//span[contains(text(),'Favorite')]")
    private WebElement favorite_button;
    @FindBy(xpath = "//span[contains(text(),'Cosul meu')]")
    private WebElement cosulMeu_button;


    public DefaultPage() {
        PageFactory.initElements(driver, this);
    }

    public EmailPage clickOnSignInButton() throws Exception {

        actionMove(contulMeu_button);
        waitAndClickElement(intraInCont_button);
        return new EmailPage();
    }

}


