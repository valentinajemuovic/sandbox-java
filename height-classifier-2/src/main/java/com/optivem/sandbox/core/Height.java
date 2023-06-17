package com.optivem.sandbox.core;

import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.math.MathContext;

@EqualsAndHashCode
public class Height {

    private static BigDecimal CENTIMETERS_PER_INCH = BigDecimal.valueOf(2.54);

    private BigDecimal centimeters;

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

    public BigDecimal toCentimeters() {
        return centimeters;
    }

    public boolean isGreaterThan(Height height) {
        return centimeters.compareTo(height.centimeters) > 0;
    }

    public boolean isLessThan(Height height) {
        return centimeters.compareTo(height.centimeters) < 0;
    }

}
