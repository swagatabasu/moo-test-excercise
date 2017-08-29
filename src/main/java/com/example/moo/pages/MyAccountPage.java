package com.example.moo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.stereotype.Component;

/**
 * Created by sba88 on 28/08/2017.
 */

@Component
public class MyAccountPage extends MooAbstractPage{

    private static final String PAGE_NAME = "MyAccountPage";
    private static final String PATH = "account";

    public MyAccountPage(){
        super(PAGE_NAME, PATH);
    }

    public MyAccountPage(String pageName, String path) {
        super(PAGE_NAME, PATH);
    }

    public WebElement orderHistoryLink(){
        return webBot.waitForExpectedElement(By.xpath(".//*[@id='htmlBody']/div[2]/nav/ul/li[3]/a"));
    }

    public WebElement emailAddressTextbox(){
        return webBot.waitForExpectedElement(By.xpath(".//*[@id='txtEmailSignIn']"));
    }

    public WebElement passwordTextbox(){
        return webBot.waitForExpectedElement(By.xpath(".//*[@id='txtPasswordSignIn']"));
    }

    public WebElement signinButton(){
        return webBot.waitForExpectedElement(By.xpath(".//*[@id='btnLogin']"));
    }

    public String usernameText(){
        return webBot.waitForExpectedElement(By.xpath(".//*[@id='spnIdentityFirstName']")).getText();
    }

    public WebElement accountDropdown(){
        return webBot.waitForExpectedElement(By.xpath("//a[@data-ga-event-label='Account']"));
    }

    public WebElement logoutLink(){
        return webBot.waitForExpectedElement(By.xpath("/.//*[@id='htmlBody']/div[1]/div[3]/div[2]/header/div[2]/div[3]/nav/ul/li[2]/ul/span[2]/li/a"));
    }

    public void hoverElements(){
        Actions builder = new Actions(webBot.getDriver());
        builder.moveToElement(accountDropdown()).moveToElement(logoutLink()).click().build().perform();

    }


//            moveToElement(accountDropdown).perform();
//    By locator = By.id("clickElementID");
//    driver.click(locator);

    public String logoutText(){
        return webBot.waitForExpectedElement(By.xpath(".//*[@id='htmlBody']/div[3]/div/div[1]/h1")).getText();
    }

}
