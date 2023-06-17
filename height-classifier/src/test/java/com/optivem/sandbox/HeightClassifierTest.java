package com.optivem.sandbox;

import com.optivem.sandbox.core.Constants;
import com.optivem.sandbox.core.HeightClassification;
import com.optivem.sandbox.core.HeightClassifier;
import com.optivem.sandbox.core.HeightGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.math.MathContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HeightClassifierTest {

    private HeightGateway heightGateway;
    private HeightClassifier heightClassifier;

    @BeforeEach
    void setup() {
        heightGateway = mock(HeightGateway.class);
        heightClassifier = new HeightClassifier(heightGateway);
    }

    @Test
    void should_classify_as_tall_given_height_is_greater_than_180cm() {
        var ssn = "123456789";
        var heightInches = toInches(BigDecimal.valueOf(181.0));
        // NOTE: Alternative: var heightInches = BigDecimal.valueOf(71.25984252); // 181cm
        when(heightGateway.getHeightInches(ssn)).thenReturn(heightInches);

        var heightClassification = heightClassifier.classify(ssn);

        assertThat(heightClassification).isEqualTo(HeightClassification.Tall);
    }

    @ParameterizedTest
    @ValueSource(ints = { 160, 161, 179, 180 })
    void should_classify_as_medium_given_height_is_between_160cm_and_180cm_inclusive(int heightCentimeters) {
        var ssn = "123456789";
        var heightInches = toInches(BigDecimal.valueOf(heightCentimeters));

        when(heightGateway.getHeightInches(ssn)).thenReturn(heightInches);

        var heightClassification = heightClassifier.classify(ssn);

        assertThat(heightClassification).isEqualTo(HeightClassification.Medium);
    }

    @Test
    void should_classify_as_short_given_height_is_less_than_160cm() {
        var ssn = "123456789";
        var heightInches = toInches(BigDecimal.valueOf(159));
        when(heightGateway.getHeightInches(ssn)).thenReturn(heightInches);

        var heightClassification = heightClassifier.classify(ssn);

        assertThat(heightClassification).isEqualTo(HeightClassification.Short);
    }

    private static BigDecimal toInches(BigDecimal centimeters) {
        return centimeters.divide(Constants.CENTIMETERS_PER_INCH, MathContext.DECIMAL64);
    }
}
