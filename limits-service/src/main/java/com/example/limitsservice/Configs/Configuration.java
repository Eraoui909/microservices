package com.example.limitsservice.Configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "limits-service")
@Component
public class Configuration {

    private Integer minimum;
    private Integer maximum;

    public Integer getMinimum() {
        return minimum;
    }

    public void setMinimum(Integer minimum) {
        this.minimum = minimum;
    }

    public Integer getMaximum() {
        return maximum;
    }

    public void setMaximum(Integer maximum) {
        this.maximum = maximum;
    }
}
