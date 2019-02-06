package stepDefinitions;

import base.TestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import pages.*;

import java.util.function.Predicate;


public class SearchStepDef extends TestBase {

    DefaultPage defaultPage;
    EmailPage emailPage;
    PasswordPage passwordPage;
    HomePage homePage;
    ResultsPage resultsPage;

    //preconditions of the test
    @Given("^user is logged in$")
    public void user_is_logged_in() throws Exception {
        defaultPage = new DefaultPage();
        emailPage = defaultPage.clickOnSignInButton();
        emailPage.insertEmail();
        passwordPage = emailPage.clickOnContinueButton();
        passwordPage.insertPassword();
        homePage = passwordPage.clickOnContinuaButton();
    }


    @When("^user search for \"(.*)\"$")
    public void user_search_for_product(String productName) throws Exception {
        resultsPage = homePage.searchProduct(productName);

    }
    @Then("^a page with \"(.*)\" is displayed$")
    public void a_page_with_expected_product_is_displayed(String keyword) {
        Assert.assertEquals(resultsPage.getListSizeByKeyword(keyword), resultsPage.getListSizeOfAllProducts());
    }
}