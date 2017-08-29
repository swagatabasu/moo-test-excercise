package com.example.moo.pages;

import com.example.moo.driver.WebDriverUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.fail;

/**
 * Created by sba88 on 28/08/2017.
 */
public abstract class AbstractPage {
    static Logger log = Logger.getLogger(AbstractPage.class);
    protected String pageName;
    protected String path;


    @Autowired
    protected WebDriverUtil webBot;

    public AbstractPage(){

    }

    public AbstractPage(String pageName, String path) {
        this.pageName = pageName;
        this.path = path;
    }


    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }

    public void go(){
        webBot.goToPage(getBaseUrl()+getPath());
    }

    public void maximise(){
        webBot.maximize();
    }

    public String getBaseUrl(){
        return webBot.getMoobaseUrl();
    }

    public String getTitle(){
        return webBot.getTitle();
    }

    public String getPageName() {
        return pageName;
    }

    public void pageRefresh(){
        webBot.getDriver().navigate().refresh();
    }

    public void sleep(int msecs){
        webBot.sleep(msecs);
    }

    public void waitForPageToLoad(){
        webBot.waitForPageToLoad();
    }




}
