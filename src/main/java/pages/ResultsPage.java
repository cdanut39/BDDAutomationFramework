package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ResultsPage extends TestBase {

    //find multiple web elements
    @FindBys({@FindBy(xpath = "//h2/a")})
    private List<WebElement> resultsList;

    public ResultsPage() {
        PageFactory.initElements(driver, this);
    }

    //method to get the name of each product
    public List<Boolean> containsProductsName(String productName) {
        //create a list of boolean
        List<Boolean> titlesList = new ArrayList<>();
        for (WebElement element : resultsList) {
            //add in list true or false depending on searched product name existence
            titlesList.add(element.getText().contains(productName));
        }
        return titlesList;
    }

}
