package stepDefinitions;

import base.TestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.*;


public class SearchStepDef extends TestBase {

    DefaultPage defaultPage;
    EmailPage emailPage;
    PasswordPage passwordPage;
    HomePage homePage;
    ResultsPage resultsPage;

    //preconditions of the test
    @Given("^user is logged in$")
    public void user_is_logged_in() {
        TestBase.intialization();
        defaultPage = new DefaultPage();
        emailPage = defaultPage.clickOnSignInButton();
        emailPage.insertEmail();
        passwordPage = emailPage.clickOnContinueButton();
        passwordPage.insertPassword();
        homePage = passwordPage.clickOnContinuaButton();
    }


    @When("^user search for \"(.*)\"$")
    public void user_search_for_product(String productName) {
        resultsPage = homePage.searchProduct(productName);

    }

    @Then("^a page with \"(.*)\" is displayed$")
    public void a_page_with_expected_product_is_displayed(String resultName) {
        //check if all displayed products contain the expected result
        for (boolean flag : resultsPage.containsProductsName(resultName)) {
            Assert.assertTrue(flag);
        }
    }
}