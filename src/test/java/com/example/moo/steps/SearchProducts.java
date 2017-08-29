package com.example.moo.steps;

import com.example.moo.pages.MyAccountPage;
import com.example.moo.pages.SearchResultPage;
import com.example.moo.pages.MooHomePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

/**
 * Created by sba88 on 28/08/2017.
 */
public class SearchProducts extends BaseStepWithWeb {

    static Logger log = Logger.getLogger(SearchProducts.class);

    @Autowired
    private MooHomePage homePage;

    @Autowired
    private SearchResultPage resultPage;

    @Autowired
    private MyAccountPage myAccount;

    @Value("${moo.userName}")
    private String username;

    @Value("${moo.password}")
    private String pwd;

    @Given("^I am on Moo Home page$")
    public void iAmOnMooHomePage() throws Throwable {
        homePage.go();
    }

    @When("^I search for a '(.*)'$")
    public void iSearchForAProduct(String product) throws Throwable {
        homePage.searchBoxLink().clear();
        homePage.searchBoxLink().sendKeys(product);
        homePage.searchButton().click();

    }

    @Then("^I verify the search result page is displayed for correct '(.*)'$")
    public void iVerifyTheSearchResultPageIsDisplayedForProduct(String product) throws Throwable {
        String resultHeader= resultPage.verifySearchCriteria().getText();

        if(resultHeader.contains(product)){
            log.info("Search page displayed for "+product);

        }else{
            log.info("Something went wrong, search results could not be retireved");
            throw new Exception();
        }


    }

    @When("^I search for an invalid '(.*)'$")
    public void iSearchForAnInvalidProduct(String product) throws Throwable {
        iSearchForAProduct(product);
    }

    @And("^I verify if the search returned an error message$")
    public void iVerifyIfTheSearchReturnedErrorMessage() throws Throwable {
        String receivedMessage= resultPage.invalidSearchMessage().getText();

        if(receivedMessage.contains("Sorry we couldn’t find anything")){
            log.info("An error message received: " );
            log.info("==================================");
            log.info(receivedMessage);
        }
    }

    @And("^I verify if the search returned valid results$")
    public void iVerifyIfTheSearchReturnedValidResults() throws Throwable {
        if(resultPage.resultCountText().getText().contains("result")){
            String count = resultPage.resultCountText().getText().substring(6,11);
            log.info("Result count: "+count);
        }
    }


}
