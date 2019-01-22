package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends GeneralActions {


    @FindBy(xpath = "//span[text()=' Contul meu ']")
    private WebElement contulMeuButton;

    @FindBy(xpath = "//div[@class='ph-dropdown-inner']//strong[text()='Salut, Cristea Danut']")
    private WebElement welcomeMessage;

    @FindBy(id = "searchboxTrigger")
    private WebElement searchBox;

    @FindBy(xpath = "//button[@class='btn btn-default searchbox-submit-button']")
    private WebElement searchButton;


    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void hoverContulMeu() throws Exception {
        actionMove(contulMeuButton);
    }

    public String getWelcomeMessageText() throws Exception {
        hoverContulMeu();
        return getTextFromElement(welcomeMessage);
    }


    public ResultsPage searchProduct(String productName) throws Exception {
        sendKeysToWebElement(searchBox, productName);
        waitAndClickElement(searchButton);
        return new ResultsPage();

    }
}
