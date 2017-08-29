package com.example.moo.driver;

/**
 * Created by sba88 on 28/08/2017.
 */
import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;


@Component
public class WebDriverFactory {

    static Logger log = Logger.getLogger(WebDriverFactory.class);

    public static final String DRIVER_FIREFOX ="firefox";

    private static final int IMPLICIT_WAIT=30;


    private  WebDriver driver;

    @Value("${browser}")
    private String browser;


    public synchronized WebDriver getDriver(){
        return getDriver(null);
    }
    public synchronized void resetDriver(){
        driver=null;
    }

    public String getBrowser(){
        return browser;
    }

    public synchronized WebDriver getDriver(String url){
        if(driver == null){
            if(browser.equalsIgnoreCase(DRIVER_FIREFOX)){
                driver=createFireFoxDriver();
            }
            if(url != null){
                driver.get(url);
            }
        }
        return driver;
    }



    private FirefoxDriver createFireFoxDriver(){
        log.debug("Creating FireFox Driver...");
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1024, 768));
        return driver;
    }


    public void resize(){
        driver.manage().window().maximize();
    }

    //    @PreDestroy
    public void quit(){
        if(driver !=null){
            driver.quit();
            driver = null;
        }
    }

    public boolean isOpen() {
        return driver != null;
    }
}
