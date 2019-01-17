package pages;


import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DefaultPage extends TestBase {


    //Using FindBy for locating elements
    @FindBy(xpath = "//a[contains(@href,'homepage')]")
    private WebElement inapoiInSite_link;
    @FindBy(xpath = "//span[text()='Contul meu ']")
    private WebElement contulMeu_button;
    @FindBy(xpath = "//a[text()='Intra in cont']")
    private WebElement intraInCont_button;
    @FindBy(xpath = "//span[contains(text(),'Favorite')]")
    private WebElement favorite_button;
    @FindBy(xpath = "//span[contains(text(),'Cosul meu')]")
    private WebElement cosulMeu_button;


    public DefaultPage() {
        //initialize the elements of the Page Object
        PageFactory.initElements(driver, this);
    }

    // Defining the user actions (Methods) that can be performed on the Default page

    //This method is used to mouse hover and then to click on a web element
    public EmailPage clickOnSignInButton() {

        //mouse hover
        Actions action = new Actions(driver);
        wait.until(ExpectedConditions.elementToBeClickable(contulMeu_button));
        action.moveToElement(contulMeu_button).build().perform();

        //wait until element became clickable
        wait.until(ExpectedConditions.elementToBeClickable(intraInCont_button));
        //click
        intraInCont_button.click();
        //return the new page(EmailPage)
        return new EmailPage();
    }
}
