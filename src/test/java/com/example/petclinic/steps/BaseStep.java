package com.example.petclinic.steps;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by sba88 on 09/06/2017.
 */
@ContextConfiguration(locations = {"classpath:cucumber.xml"})
public abstract class BaseStep {

    @Value("${env.name}")
    public String env;


}
