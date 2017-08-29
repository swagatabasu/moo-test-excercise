package com.example.moo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

/**
 * Created by sba88 on 28/08/2017.
 */
@Component
public class MooHomePage extends MooAbstractPage {
    private static final String PAGE_NAME = "MooHome";
    private static final String PATH = "";

    public MooHomePage(){
        super(PAGE_NAME, PATH);
    }

    public MooHomePage(String pageName, String path) {
        super(PAGE_NAME, PATH);
    }

    public WebElement searchBoxLink(){
        return webBot.findElement(By.xpath(".//*[@id='query']"));
    }

    public WebElement searchButton(){ return webBot.waitForExpectedElement(By.xpath(".//*[@id='search']/div/button"));}

    public WebElement signInLink(){
        return webBot.waitForExpectedElement(By.xpath(".//li[@class='nav-main__item -l1 -tools -sign-in js-header-sign-in js-header-sign-in-primary-link']/a"));
    }


}
