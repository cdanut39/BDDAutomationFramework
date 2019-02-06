package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResultsPage extends GeneralActions {

    //find multiple web elements
    @FindBys({@FindBy(xpath = "//h2/a")})
    private List<WebElement> resultsList;

    public ResultsPage() {
        PageFactory.initElements(driver, this);
    }

    //method to get the size of filtered products list
    public int getListSizeByKeyword(String keyword) {
        List<String> filteredTitles = resultsList.stream().map(WebElement::getText).filter(x -> x.contains(keyword)).collect(Collectors.toList());
        return filteredTitles.size();
    }

    public int getListSizeOfAllProducts() {
        return resultsList.size();
    }

}
