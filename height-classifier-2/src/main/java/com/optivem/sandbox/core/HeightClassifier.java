package com.optivem.sandbox.core;

public class HeightClassifier {
    private static final Height TALL_THRESHOLD = Height.ofCentimeters(180);

    private HeightGateway heightGateway;

    public HeightClassifier(HeightGateway heightGateway) {
        this.heightGateway = heightGateway;
    }

    public boolean isTall(String ssn) {
        var height = heightGateway.getHeight(ssn);
        return height.compareTo(TALL_THRESHOLD) > 0;
    }
}
