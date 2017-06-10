package com.example.petclinic.steps;

import com.example.petclinic.pages.PetclinicFindOwnersPage;
import com.example.petclinic.pages.PetclinicHomePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

/**
 * Created by sba88 on 09/06/2017.
 */
public class SearchOwners extends BaseStepWithWeb {

    static Logger log = Logger.getLogger(SearchOwners.class);

    @Autowired
    private PetclinicHomePage homePage;

    @Autowired
    private PetclinicFindOwnersPage searchOwnerPage;

    public String fName,lName, updatedCity;

    @Given("^I am on Petclinic Home page$")
    public void iAmOnPetclinicHomePage() throws Throwable {

        homePage.go();

    }

    @And("^I search for all pet owners$")
    public void iSearchForAllPetOwners() throws Throwable {
        iAmOnFindOwnersPage();
        searchOwnerPage.findOwnersButton().click();

    }

    @Then("^I verify a list of owners is displayed$")
    public void iVerifyIAmDisplayedAListOfOwners() throws Throwable {
        assertEquals("Owners",searchOwnerPage.ownersListText().getText());

    }

    @And("^I click to see '(.*)' details$")
    public void iClickToSeeOwnerDetails(String ownerName) throws Throwable {
        List<WebElement> ownerList = searchOwnerPage.ownerList();

        for(WebElement row: ownerList){
            if(row.getText().contains(ownerName)){
                row.click();
                break;
            }
        }

    }

    @When("^I search for a specific owner by '(.*)'$")
    public void iSearchForASpecificOwnerByLastName(String lastName) throws Throwable {
        iAmOnFindOwnersPage();
        searchOwnerPage.ownerSearchBox().clear();
        searchOwnerPage.ownerSearchBox().sendKeys(lastName);
        searchOwnerPage.findOwnersButton().click();
    }

    @Then("^I verify if there is any record present for the searched owner$")
    public void iVerifyIfThereIsAnyRecordPresentForTheSearchedOwner() throws Throwable {
        boolean isOwnerFound = false;

        isOwnerFound=searchOwnerPage.editOwnerButton().isEnabled();

        if(isOwnerFound) {
            log.info("Owner details found");
        }else{
            log.info("No search result found");
        }


    }

    @Given("^I am on Find Owners Page$")
    public void iAmOnFindOwnersPage() throws Throwable {
        homePage.go();
        homePage.findOwnersLink().click();
        TimeUnit.SECONDS.sleep(2);
    }

    @And("^I click on Add Owners button$")
    public void iClickOnAddOwnersButton() throws Throwable {
        searchOwnerPage.addOwnerButton().click();
    }

    @When("^I submit '(.*)', '(.*)', '(.*)', '(.*)', '(.*)' data$")
    public void iSubmitFirstNameLastNameAddressCityTelephoneData(String firstName,String lastName, String address, String city, String phone) throws Throwable {

        fName =firstName;
        lName =lastName;

        searchOwnerPage.ownerFirstNameTextBox().clear();
        searchOwnerPage.ownerFirstNameTextBox().sendKeys(firstName);
        searchOwnerPage.ownerLastNameTextBox().clear();
        searchOwnerPage.ownerLastNameTextBox().sendKeys(lastName);
        searchOwnerPage.ownerAddressTextBox().clear();
        searchOwnerPage.ownerAddressTextBox().sendKeys(address);
        searchOwnerPage.ownerCityTextBox().clear();
        searchOwnerPage.ownerCityTextBox().sendKeys(city);
        searchOwnerPage.ownerPhoneTextBox().clear();
        searchOwnerPage.ownerPhoneTextBox().sendKeys(phone);

        searchOwnerPage.submitOwnerDetailsButton().click();


    }


    @Then("^I see the owner information successfully displayed$")
    public void iSeeTheOwnerInformationSuccessfullyDisplayed() throws Throwable {
        if(searchOwnerPage.verifyOwnerName().getText().contains(fName)){
            log.info("Correct owner details added");
        }
    }

    @Then("^I edit the city information with '(.*)'$")
    public void iEditTheCityInformationWithUpdatedCity(String updatedCity) throws Throwable {
        this.updatedCity = updatedCity;
        searchOwnerPage.editOwnerButton().click();
        searchOwnerPage.ownerCityTextBox().clear();
        searchOwnerPage.ownerCityTextBox().sendKeys(updatedCity);
        searchOwnerPage.updateOwnerButton().click();

    }

    @And("^I see the updated information present in Owner's details$")
    public void iSeeTheUpdatedInformationPresentInOwnerSDetails() throws Throwable {
        if(updatedCity.equalsIgnoreCase(searchOwnerPage.updatedCityText().getText())){
            log.info("City correctly updated");
        }


    }


    @Then("^I see an error message if information are incorrect$")
    public void iSeeAnErrorMessageIfInformationAreIncorrect() throws Throwable {
        try{
            List<WebElement> hasError = searchOwnerPage.erroText();

            for(WebElement w:hasError){
                if(w.getText().contains("may not be empty")){
                    log.info("All fields are mandatory. Input cannot be empty.");
                    break;
                }else if(w.getText().contains("numeric value out of bounds")){
                    log.info("Phone number can only be numeric. Please check your input");
                    break;
                }
            }
        }catch (NoSuchElementException e){
            log.info("No error found");
        }

    }

    @And("^I add a new pet with '(.*)','(.*)' and '(.*)'$")
    public void iAddANewPetWithNameBirthDateAndType(String petName,String birthDate, String type) throws Throwable {

        searchOwnerPage.addPetButton().click();
        searchOwnerPage.petNameTextBox().clear();
        searchOwnerPage.petNameTextBox().sendKeys(petName);
        searchOwnerPage.petBrithDate().clear();
        searchOwnerPage.petBrithDate().sendKeys(birthDate);
        searchOwnerPage.petType(type);
        searchOwnerPage.updatePetButton().click();

        try{
            if(searchOwnerPage.addVisitLink().getText().contains("Visit")){
                log.info("Pet successfully added");
            }
        }catch(NoSuchElementException e){
            log.info("Error adding a new pet");
        }

    }

    @And("^I schedule a visit for the pet$")
    public void iScheduleAVisitForThePet() throws Throwable {
        searchOwnerPage.addVisitLink().click();
        searchOwnerPage.petSicknessDesc().clear();
        searchOwnerPage.petSicknessDesc().sendKeys("Infection");

        searchOwnerPage.addVisitButton().click();
    }
}
