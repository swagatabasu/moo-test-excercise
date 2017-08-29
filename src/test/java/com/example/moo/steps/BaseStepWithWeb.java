package com.example.moo.steps;

import com.example.moo.driver.WebDriverUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.PostConstruct;

/**
 * Created by sba88 on 28/08/2017.
 */
@ContextConfiguration(locations = {"classpath:cucumber.xml"})
public abstract class BaseStepWithWeb extends BaseStep {

    static Logger log = Logger.getLogger(BaseStepWithWeb.class);

    @Autowired
    protected WebDriverUtil webBot;

    @PostConstruct
    public void init(){


    }



}
