package com.optivem.sandbox.application;

public class HeightClassifier {

    private HeightGateway heightGateway;

    public HeightClassifier(HeightGateway heightGateway) {
        this.heightGateway = heightGateway;
    }

    public HeightClassification classify(String ssn) {
        var height = heightGateway.getHeight(ssn);

        if(height > 180) {
            return HeightClassification.Tall;
        }

        if(height < 160) {
            return HeightClassification.Short;
        }

        return HeightClassification.Medium;
    }
}
