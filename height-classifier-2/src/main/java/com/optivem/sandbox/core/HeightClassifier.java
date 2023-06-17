package com.optivem.sandbox.core;

import java.math.BigDecimal;
import java.math.MathContext;

public class HeightClassifier {
    private static final BigDecimal TALL_THRESHOLD = BigDecimal.valueOf(180);
    private static final BigDecimal SHORT_THRESHOLD = BigDecimal.valueOf(160);

    private HeightGateway heightGateway;

    public HeightClassifier(HeightGateway heightGateway) {
        this.heightGateway = heightGateway;
    }

    public HeightClassification classify(String ssn) {
        var heightInches = heightGateway.getHeightInches(ssn);

        var heightCentimeters = heightInches.multiply(Constants.CENTIMETERS_PER_INCH, MathContext.DECIMAL64);

        if(heightCentimeters.compareTo(TALL_THRESHOLD) > 0) {
            return HeightClassification.Tall;
        }

        if(heightCentimeters.compareTo(SHORT_THRESHOLD) < 0) {
            return HeightClassification.Short;
        }

        return HeightClassification.Medium;
    }
}
