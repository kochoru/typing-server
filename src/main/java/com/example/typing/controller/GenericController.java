package com.example.typing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenericController {

    @Autowired
    Environment env;

    @GetMapping(path = "profiles")
    public String getProfiles() {
        String returnVal = "";
        for (String val : env.getActiveProfiles()) {
            returnVal = returnVal + val +", ";
        }
        return returnVal;
    }
}
