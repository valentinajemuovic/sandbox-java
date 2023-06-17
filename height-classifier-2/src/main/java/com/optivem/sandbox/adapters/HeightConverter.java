package com.optivem.sandbox.adapters;

import com.optivem.sandbox.core.Height;

import java.math.BigDecimal;
import java.math.MathContext;

public class HeightConverter {
    private static BigDecimal CENTIMETERS_PER_INCH = BigDecimal.valueOf(2.54);

    public static Height fromInches(BigDecimal inches) {
        var centimeters = inches.multiply(CENTIMETERS_PER_INCH, MathContext.DECIMAL64);
        return Height.ofCentimeters(centimeters);
    }
}
