package com.optivem.sandbox.core;

import java.math.BigDecimal;

public class Height {
    private final BigDecimal centimeters;

    public Height(BigDecimal centimeters) {
        this.centimeters = centimeters;
    }

    public BigDecimal getCentimeters() {
        return centimeters;
    }
}
