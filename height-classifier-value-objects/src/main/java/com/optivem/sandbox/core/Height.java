package com.optivem.sandbox.core;

import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode
public class Height implements Comparable<Height> {
    private final BigDecimal centimeters;

    private Height(BigDecimal centimeters) {
        this.centimeters = centimeters;
    }

    public static Height ofCentimeters(BigDecimal centimeters) {
        return new Height(centimeters);
    }

    public static Height ofCentimeters(double centimeters) {
        return ofCentimeters(BigDecimal.valueOf(centimeters));
    }

    public BigDecimal getCentimeters() {
        return centimeters;
    }

    @Override
    public int compareTo(Height o) {
        return getCentimeters().compareTo(o.getCentimeters());
    }
}
