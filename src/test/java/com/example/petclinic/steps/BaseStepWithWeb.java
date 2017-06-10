package com.example.petclinic.steps;

import com.example.petclinic.driver.WebDriverUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.PostConstruct;

/**
 * Created by sba88 on 09/06/2017.
 */
@ContextConfiguration(locations = {"classpath:cucumber.xml"})
public abstract class BaseStepWithWeb extends BaseStep {

    static Logger log = Logger.getLogger(BaseStepWithWeb.class);

    @Autowired
    protected WebDriverUtil webBot;

    @PostConstruct
    public void init(){


    }

    public void expandfirstRow(){
        // If not expanded , expanded row

        if (webBot.isElementExists(By.className("expandoOpen"))){
            log.info("First row NOT expanded, so Attempting to expand first row ...");
            webBot.findElement(By.className("expandoOpen")).click();
        } else {
            log.info("Plus button dont exist, so First row already expanded ...");
        }
    }

    public void colapsefirstRow(){

        // Sometimes + or - button does not show correct status that it is collapsed or expanded
        // check if child grid exists
        if(webBot.isElementExists(By.cssSelector("tr[class='datagrid-child'] td[class='datagrid-child']"))){
            log.info("Child grid exists, so it means it is already expanded..");
            // It is alredy expanded hence it it needs to be collapsed
            if (webBot.isElementExists(By.className("expandoClose"))){
                log.info("Attempting to collapse first row ...");
                webBot.findElement(By.className("expandoClose")).click();
            }else {
                // Some times it might be alrdeay expanded but it might wrongly show + button
                expandfirstRow();
            }

        } else {
            log.info("Child grid dont  exists, so it means it is already collapsed..");
        }

        // If not collapsed , collapse row

    }

}
