package com.example.moo.pages;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by sba88 on 28/08/2017.
 */
public class MooAbstractPage extends AbstractPage {

    @Value("${env.name}")
    public String env;

    public MooAbstractPage(String pageName, String path) {
        super(pageName,path);
    }

    @Override
    public String getBaseUrl(){
        return webBot.getMoobaseUrl();
    }

}
