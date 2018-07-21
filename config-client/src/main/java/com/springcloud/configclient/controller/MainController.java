package com.springcloud.configclient.controller;

import com.springcloud.configclient.config.ConfigClientConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class MainController {

    @Autowired
    private ConfigClientConfiguration properties;

    @Value("${some.other.property}")
    private String otherProperty;

    @GetMapping("/configs")
    public String getConfig() {

        return String.format("Properties: [%s    || %s].", properties.getProperty(), otherProperty);
    }
}
