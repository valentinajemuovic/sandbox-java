package com.optivem.sandbox.core;

import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.math.MathContext;

@EqualsAndHashCode
public class Height implements Comparable<Height> {

    private static final BigDecimal CENTIMETERS_PER_INCH = BigDecimal.valueOf(2.54);

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

    public static Height ofInches(BigDecimal inches) {
        var centimeters = inches.multiply(CENTIMETERS_PER_INCH, MathContext.DECIMAL64);
        return ofCentimeters(centimeters);
    }

    public static Height ofInches(double inches) {
        return ofInches(BigDecimal.valueOf(inches));
    }

    public BigDecimal getCentimeters() {
        return centimeters;
    }

    @Override
    public int compareTo(Height other) {
        return this.centimeters.compareTo(other.centimeters);
    }
}
