package com.optivem.sandbox.core;

public class HeightClassifier {
    private static final Height TALL_THRESHOLD = Height.ofCentimeters(180);
    private static final Height SHORT_THRESHOLD = Height.ofCentimeters(160);

    private HeightGateway heightGateway;

    public HeightClassifier(HeightGateway heightGateway) {
        this.heightGateway = heightGateway;
    }

    public HeightClassification classify(String ssn) {
        var height = heightGateway.getHeight(ssn);

        if(height.compareTo(TALL_THRESHOLD) > 0) {
            return HeightClassification.Tall;
        }

        if(height.compareTo(SHORT_THRESHOLD) < 0) {
            return HeightClassification.Short;
        }

        return HeightClassification.Medium;
    }
}
