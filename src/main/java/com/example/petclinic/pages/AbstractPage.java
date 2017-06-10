package com.example.petclinic.pages;

import com.example.petclinic.driver.WebDriverUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.fail;

/**
 * Created by sba88 on 09/06/2017.
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
        return webBot.getPetclinicbaseUrl();
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


    /*
   Waits for a specific element to be visible for up to 10 seconds
    */
    public void waitForElementToBeVisible(By by) throws Throwable{
        log.info("Waiting for element to appear "+by);
        for(int i = 0; i <= 40 ; i++) {
            // find it each time to prevent selenium reference going stale
            WebElement e = webBot.findElement(by);
            if (e.isDisplayed()) {
                log.info("Element is visible");
                return;
            } else {
                Thread.sleep(250);
            }
            log.info(".");
        }
        fail("Element did not become visible: "+by);
    }

}
