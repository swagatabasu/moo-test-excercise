package com.example.petclinic.pages;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by sba88 on 09/06/2017.
 */
public class PetclinicAbstractPage extends AbstractPage {

    @Value("${env.name}")
    public String env;

    public PetclinicAbstractPage(String pageName, String path) {
        super(pageName,path);
    }

    @Override
    public String getBaseUrl(){
        return webBot.getPetclinicbaseUrl();
    }

}
