package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends GeneralActions {

    String user = prop.getProperty("USER");

    @FindBy(id = "my_account")
    private WebElement contulMeuButton;

    @FindBy(id = "searchboxTrigger")
    private WebElement searchBox;

    @FindBy(xpath = "//button[@class='btn btn-default searchbox-submit-button']")
    private WebElement searchButton;


    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void hoverContulMeu()  {
        actionMove(contulMeuButton);
    }

    public String getWelcomeMessageText() {
        String user = prop.getProperty("USER");
        hoverContulMeu();
        return driver.findElement(By.xpath("//div[@class='ph-dropdown-inner']//strong[text()='Salut, " + user + "']")).getText();
    }


    public ResultsPage searchProduct(String productName){
        sendKeysToWebElement(searchBox, productName);
        waitAndClickElement(searchButton);
        return new ResultsPage();

    }
}
