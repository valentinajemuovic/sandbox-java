package com.optivem.sandbox.core;

import java.math.BigDecimal;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Height height = (Height) o;
        return Objects.equals(centimeters, height.centimeters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(centimeters);
    }

    @Override
    public int compareTo(Height o) {
        return this.centimeters.compareTo(o.centimeters);
    }
}
