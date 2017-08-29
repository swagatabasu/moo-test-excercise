package com.example.moo.steps;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by sba88 on 28/08/2017.
 */
@ContextConfiguration(locations = {"classpath:cucumber.xml"})
public abstract class BaseStep {

    @Value("${env.name}")
    public String env;


}
