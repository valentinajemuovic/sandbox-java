package com.optivem.sandbox.core;

import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode
public class Height {
    private BigDecimal centimeters;

    private Height(BigDecimal centimeters) {
        this.centimeters = centimeters;
    }

    public static Height of(BigDecimal centimeters) {
        return new Height(centimeters);
    }

    public static Height of(double centimeters) {
        return of(BigDecimal.valueOf(centimeters));
    }

    public boolean isGreaterThan(Height height) {
        return centimeters.compareTo(height.centimeters) > 0;
    }

    public boolean isLessThan(Height height) {
        return centimeters.compareTo(height.centimeters) < 0;
    }

}
