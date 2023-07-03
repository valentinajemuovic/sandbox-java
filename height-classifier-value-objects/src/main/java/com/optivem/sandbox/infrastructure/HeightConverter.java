package com.optivem.sandbox.infrastructure;

import com.optivem.sandbox.core.Height;

import java.math.BigDecimal;
import java.math.MathContext;

public class HeightConverter {
    private static final BigDecimal CENTIMETERS_PER_INCH = BigDecimal.valueOf(2.54);

    public static Height fromInches(BigDecimal heightInches) {
        var heightCentimeters = heightInches.multiply(CENTIMETERS_PER_INCH, MathContext.DECIMAL64);
        return Height.ofCentimeters(heightCentimeters);
    }

    public static Height fromInches(double heightInches) {
        return fromInches(BigDecimal.valueOf(heightInches));
    }
}
