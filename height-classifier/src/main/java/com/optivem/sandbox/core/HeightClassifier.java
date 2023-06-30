package com.optivem.sandbox.core;

import java.math.BigDecimal;
import java.math.MathContext;

public class HeightClassifier {
    private static final BigDecimal CENTIMETERS_PER_INCH = BigDecimal.valueOf(2.54);
    private static final BigDecimal TALL_THRESHOLD = BigDecimal.valueOf(180);

    private final HeightGateway heightGateway;

    public HeightClassifier(HeightGateway heightGateway) {
        this.heightGateway = heightGateway;
    }

    public boolean isTall(String ssn) {
        var heightInches = heightGateway.getHeightInches(ssn);
        var heightCentimeters = heightInches.multiply(CENTIMETERS_PER_INCH, MathContext.DECIMAL64);
        return heightCentimeters.compareTo(TALL_THRESHOLD) > 0;
    }
}
