package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DefaultPage extends GeneralActions {
    @FindBy(id = "my_account")
    private WebElement contulMeu_button;
    @FindBy(xpath = "//a[text()='Intra in cont']")
    private WebElement intraInCont_button;
    @FindBy(xpath = "//span[contains(text(),'Favorite')]")
    private WebElement favorite_button;
    @FindBy(xpath = "//span[contains(text(),'Cosul meu')]")
    private WebElement cosulMeu_button;
    @FindBy(xpath = "//div[@class='header-back']/a[contains(@href,'homepage')]")
    private WebElement inapoiInSite;
    String currentUrl;

    public DefaultPage() {

        PageFactory.initElements(driver, this);
    }

    public EmailPage clickOnSignInButton() throws Exception {

        currentUrl = driver.getCurrentUrl();
        if (currentUrl.equalsIgnoreCase("https://www.emag.ro/")) {
            waitAndClickElement(contulMeu_button);
//            contulMeu_button.click();
        } else {
            waitAndClickElement(inapoiInSite);
            waitAndClickElement(contulMeu_button);
        }
        return new EmailPage();
    }

}


