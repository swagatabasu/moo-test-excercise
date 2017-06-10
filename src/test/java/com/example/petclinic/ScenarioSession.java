package com.example.petclinic;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by rav07 on 04/02/2016.
 */
@Component
@Scope("cucumber-glue")
public class ScenarioSession {
    static Logger log = Logger.getLogger(ScenarioSession.class);


    private Map<String, Object> sessionData = new HashMap<String, Object>();

    public <T> T getData(Object key){
        return (T)sessionData.get(key.toString());
    }

    public <T> T getData(String key){
        return (T)sessionData.get(key);
    }

    public void putData(String key, Object value){
        sessionData.put(key, value);
    }

    public void putData(Object key, Object value){
        sessionData.put(key.toString(), value);
    }


}
