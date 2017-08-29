package com.example.moo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by sba88 on 28/08/2017.
 */

@Component
public class SearchResultPage extends MooAbstractPage {

    private static final String PAGE_NAME = "SearchResultPage";
    private static final String PATH = "search";

    public SearchResultPage(){
        super(PAGE_NAME, PATH);
    }

    public SearchResultPage(String pageName, String path) {
        super(PAGE_NAME, PATH);
    }

    public WebElement verifySearchCriteria(){
        return  webBot.waitForExpectedElement(By.xpath("//*[@class='col-12 page-header']/h1"));
    }

   public WebElement invalidSearchMessage(){
       return webBot.waitForExpectedElement(By.xpath(".//div[@class='gs-snippet']"));

   }

   public WebElement resultCountText(){
       return webBot.waitForExpectedElement(By.xpath(".//*[@id='resInfo-0']"));
   }

}
