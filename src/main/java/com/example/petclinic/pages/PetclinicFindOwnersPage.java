package com.example.petclinic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by sba88 on 09/06/2017.
 */

@Component
public class PetclinicFindOwnersPage extends PetclinicAbstractPage {

    private static final String PAGE_NAME = "PetclinicFindOwners";
    private static final String PATH = "owners/find";

    public PetclinicFindOwnersPage(){
        super(PAGE_NAME, PATH);
    }

    public PetclinicFindOwnersPage(String pageName, String path) {
        super(PAGE_NAME, PATH);
    }

    public WebElement findOwnersButton(){
        return webBot.findElement(By.xpath(".//*[@id='search-owner-form']/div[2]/div/button"));
    }

    public WebElement ownersListText(){
        return webBot.findElement(By.xpath("html/body/div[1]/div/h2"));
    }

    public WebElement ownerSearchBox(){
        return webBot.findElement(By.xpath("//input[@id='lastName']"));
    }


    public WebElement searchNotFoundText(){
        return webBot.findElement(By.xpath(".//*[@id='lastName']/div/span/div/p"));
    }

    public WebElement addOwnerButton(){
        return webBot.waitForExpectedElement(By.xpath("html/body/div[1]/div/a"));
    }

    public WebElement ownerFirstNameTextBox(){
        return webBot.findElement(By.id("firstName"));
    }

    public WebElement ownerLastNameTextBox(){
        return webBot.findElement(By.id("lastName"));
    }

    public WebElement ownerAddressTextBox(){
        return webBot.findElement(By.id("address"));
    }

    public WebElement ownerCityTextBox(){
        return webBot.findElement(By.id("city"));
    }

    public WebElement ownerPhoneTextBox(){
        return webBot.findElement(By.id("telephone"));
    }

    public WebElement submitOwnerDetailsButton(){
        return webBot.findElement(By.xpath(".//*[@id='add-owner-form']/div[2]/div/button"));
    }

    public WebElement addOwnerAssertionTextElement(){
        return webBot.findElement(By.xpath("html/body/div[1]/div/h2[2]"));
    }

    public WebElement verifyOwnerName(){
        return webBot.waitForExpectedElement(By.cssSelector(".table.table-striped>tbody>tr>td>b"));
    }

    public WebElement editOwnerButton(){
        return webBot.findElement(By.xpath("html/body/div[1]/div/a[1]"));
    }

    public WebElement addPetButton(){
        return webBot.findElement(By.xpath("html/body/div[1]/div/a[2]"));
    }

    public WebElement updateOwnerButton(){
        return webBot.findElement(By.xpath(".//*[@id='add-owner-form']/div[2]/div/button"));
    }

    public WebElement updatedCityText(){
        return webBot.findElement(By.xpath("html/body/div[1]/div/table[1]/tbody/tr[3]/td"));
    }

    public List<WebElement> ownerList(){
        return webBot.findElements(By.xpath("html/body/div[1]/div/table/tbody/tr/td/a"));
    }

    public List<WebElement> erroText(){
        return webBot.waitForExpectedElements(By.xpath(".//*[@id='add-owner-form']/div[1]/div[@class='form-group has-error']"));
    }

    public WebElement petNameTextBox(){
        return webBot.findElement(By.xpath(".//*[@id='name']"));
    }

    public WebElement petBrithDate(){
        return webBot.findElement(By.xpath(".//*[@id='birthDate']"));
    }

    public void petType(String text){
         webBot.selectDropDown(By.xpath(".//*[@id='type']"),text);
    }

    public WebElement updatePetButton(){
        return webBot.findElement(By.xpath("html/body/div[1]/div/form/div[2]/div/button"));
    }

    public WebElement addVisitLink(){
        return webBot.findElement(By.xpath("html/body/div[1]/div/table[2]/tbody/tr/td[2]/table/tbody/tr/td[2]/a"));
    }

    public WebElement petSicknessDesc(){
        return webBot.findElement(By.xpath(".//*[@id='description']"));
    }

    public WebElement addVisitButton(){
        return webBot.findElement(By.xpath("html/body/div[1]/div/form/div[2]/div/button"));
    }

}
