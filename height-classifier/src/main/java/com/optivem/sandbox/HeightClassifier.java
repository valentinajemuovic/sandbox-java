package com.optivem.sandbox;

public class HeightClassifier {
    public HeightClassification classify(int height) {
        if(height > 180) {
            return HeightClassification.Tall;
        }

        if(height < 160) {
            return HeightClassification.Short;
        }

        return HeightClassification.Medium;
    }
}
