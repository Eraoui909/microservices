package com.example.limitsservice.controllers;


import com.example.limitsservice.Beans.Limit;
import com.example.limitsservice.Configs.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsServiceController {

    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public Limit showLimits(){
        return new Limit(configuration.getMinimum(), configuration.getMaximum());
    }
}
