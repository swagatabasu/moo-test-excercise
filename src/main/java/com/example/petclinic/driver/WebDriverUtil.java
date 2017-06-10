package com.example.petclinic.driver;

/**
 * Created by sba88 on 09/06/2017.
 */
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


@Component
@Scope("cucumber-glue")
public class WebDriverUtil {
    static Logger log = Logger.getLogger(WebDriverUtil.class);
    private static final int DRIVER_WAIT = 30;


    @Autowired
    private WebDriverFactory webDriverFactory;


    @Value("${petclinic.url}")
    private String petclinicbaseURL;

    public WebDriverUtil(){

    }

    public String getBrowser(){
        return webDriverFactory.getBrowser();
    }

    public WebDriverUtil(WebDriverFactory webDriverFactory) {
        this.webDriverFactory = webDriverFactory;
    }

    public WebDriver getDriver() {
        return webDriverFactory.getDriver();
    }

    @PreDestroy
    public void quit() {
        if (webDriverFactory.isOpen()) {
            webDriverFactory.getDriver().manage().deleteAllCookies();
            webDriverFactory.quit();

        }
    }

    public void maximize(){
        if(webDriverFactory.isOpen()){
            webDriverFactory.getDriver().manage().window().maximize();
        }
    }

    public  boolean isBrowserOpen(){
        return webDriverFactory.isOpen();
    }

    public String getTitle() {
        return getDriver().getTitle();
    }


    public void goToPage(String url) {
        log.debug("Loading URL: " + url);
        getDriver().get(url);
    }



    public String getPetclinicbaseUrl(){
        return petclinicbaseURL;
    }



    public void clearCookies() {
        log.debug("Deleting all cookies");
        getDriver().manage().deleteAllCookies();
    }



    public void navigateBack(){
        getDriver().navigate().back();
    }

    public WebElement findElement(By locator) {
        while(true) {
            try {
                return getDriver().findElement(locator);
            }
            catch (StaleElementReferenceException e) {
                log.info("Retrieved a stale element, so retrying");
            }
        }
    }

    public List<WebElement> findElements(By locator) {
        return getDriver().findElements(locator);
    }

    public WebElement waitForExpectedElement(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), DRIVER_WAIT);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public List<WebElement> waitForExpectedElements(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), DRIVER_WAIT);
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public WebElement waitForExpectedElement(By locator, int waitTime) {
        WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public List<WebElement> waitForExpectedElements(By locator, int waitTime) {
        WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public void waitForPageToLoad(){
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), DRIVER_WAIT);

        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return ((JavascriptExecutor)webDriver).executeScript("return document.readyState").equals("complete");
            }
        });
    }

    public  void selectDropDown(By by, String text) {
        WebElement dropdownList  = waitForExpectedElement(by);

        Select element = new Select(dropdownList);
        sleep(2000);
        element.selectByVisibleText(text);
    }

    public boolean isElementExists(WebElement element, By selector){
        List<WebElement> found = null;
        if (element != null)
            found = element.findElements(selector);
        else
            found = getDriver().findElements(selector);
        if (found == null || found.size() == 0)
            return false;
        return true;
    }

    public boolean isElementExists( By selector){
        List<WebElement> found = null;
        found = getDriver().findElements(selector);
        if (found == null || found.size() == 0)
            return false;
        return true;
    }

    public void sleep(int msecs){
        try {
            Thread.sleep(msecs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
