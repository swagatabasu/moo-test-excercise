package com.example.moo.steps;

import com.example.moo.pages.MooHomePage;
import com.example.moo.pages.MyAccountPage;
import com.example.moo.pages.SearchResultPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.concurrent.TimeUnit;

/**
 * Created by sba88 on 28/08/2017.
 */
public class MyAccount extends BaseStepWithWeb {

    static Logger log = Logger.getLogger(MyAccount.class);

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


    @When("^I login as an existing user$")
    public void iLoginAsExistingUser() throws Throwable {
        homePage.signInLink().click();
        login();
        TimeUnit.SECONDS.sleep(3);

    }

    public void login() throws Throwable{
        myAccount.emailAddressTextbox().clear();
        myAccount.emailAddressTextbox().sendKeys(username);
        myAccount.passwordTextbox().clear();
        myAccount.passwordTextbox().sendKeys(pwd);
        myAccount.signinButton().click();
        TimeUnit.SECONDS.sleep(3);
    }

    @And("^verify the login was successful for given '(.*)'$")
    public void verifyTheLoginWasSuccessful(String name) throws Throwable {
        if(myAccount.usernameText().contains(name)){
            
            log.info("Login is successful for "+name);
        }else{
            log.info("Unsuccessful login");
        }
    }

    @Then("^I check my order history and logout$")
    public void iCheckMyOrderHistoryAndLogout() throws Throwable {
       myAccount.orderHistoryLink().click();


    }
}
