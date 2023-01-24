package com.example.limitsservice.Beans;

public class Limit {

    private Integer maximum;
    private Integer minimum;

    public Limit() {
    }

    public Limit(Integer minimum, Integer maximum) {
        this.maximum = maximum;
        this.minimum = minimum;
    }

    public Integer getMaximum() {
        return maximum;
    }

    public void setMaximum(Integer maximum) {
        this.maximum = maximum;
    }

    public Integer getMinimum() {
        return minimum;
    }

    public void setMinimum(Integer minimum) {
        this.minimum = minimum;
    }
}
