package com.optivem.sandbox.core;

import java.math.BigDecimal;
import java.math.MathContext;

public class HeightClassifier {

    private static BigDecimal CENTIMETERS_PER_INCH = BigDecimal.valueOf(2.54);

    private HeightGateway heightGateway;

    public HeightClassifier(HeightGateway heightGateway) {
        this.heightGateway = heightGateway;
    }

    public HeightClassification classify(String ssn) {
        var heightInInches = heightGateway.getHeight(ssn);

        var heightInCentimeters = heightInInches.multiply(CENTIMETERS_PER_INCH, MathContext.DECIMAL64);

        if(heightInCentimeters.compareTo(BigDecimal.valueOf(180)) > 0) {
            return HeightClassification.Tall;
        }

        if(heightInCentimeters.compareTo(BigDecimal.valueOf(160)) < 0) {
            return HeightClassification.Short;
        }

        return HeightClassification.Medium;
    }
}
