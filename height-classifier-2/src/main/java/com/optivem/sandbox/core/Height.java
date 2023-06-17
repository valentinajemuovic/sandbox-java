package com.optivem.sandbox.core;

import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode
public class Height {
    private BigDecimal centimeters;

    public Height(BigDecimal centimeters) {
        this.centimeters = centimeters;
    }

    public boolean isGreaterThan(Height height) {
        return centimeters.compareTo(height.centimeters) > 0;
    }

    public boolean isLessThan(Height height) {
        return centimeters.compareTo(height.centimeters) < 0;
    }

}
