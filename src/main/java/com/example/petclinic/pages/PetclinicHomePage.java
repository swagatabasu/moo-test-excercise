package com.example.petclinic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

/**
 * Created by sba88 on 09/06/2017.
 */
@Component
public class PetclinicHomePage extends PetclinicAbstractPage{
    private static final String PAGE_NAME = "PetclinicHome";
    private static final String PATH = "";

    public PetclinicHomePage(){
        super(PAGE_NAME, PATH);
    }

    public PetclinicHomePage(String pageName, String path) {
        super(PAGE_NAME, PATH);
    }

    public WebElement findOwnersLink(){
        return webBot.findElement(By.xpath(".//*[@id='main-navbar']/ul/li[3]/a"));
    }
}
