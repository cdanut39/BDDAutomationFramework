package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends TestBase {


    @FindBy(xpath = "//span[text()=' Contul meu ']")
    private WebElement contulMeuButton;

    @FindBy(xpath = "//div[@class='ph-dropdown-inner']//strong[contains(text(),'Salut, ')]")
    private WebElement welcomeMessage;

    @FindBy(id = "searchboxTrigger")
    private WebElement searchBox;

    @FindBy(xpath = "//button[@class='btn btn-default searchbox-submit-button']")
    private WebElement searchButton;


    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void hoverContulMeu()  {
        Actions action = new Actions(driver);
        wait.until(ExpectedConditions.elementToBeClickable(contulMeuButton));
        action.moveToElement(contulMeuButton).build().perform();
    }

    public String getWelcomeMessageText() {
        hoverContulMeu();
        return welcomeMessage.getText();
    }

    public ResultsPage searchProduct(String productName) {
        //write the name of the product in the search box
        searchBox.sendKeys(productName);
        searchButton.click();
        //return the landing page with results
        return new ResultsPage();
    }
}
