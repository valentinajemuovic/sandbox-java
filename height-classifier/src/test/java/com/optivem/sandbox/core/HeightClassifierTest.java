package com.optivem.sandbox.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.stream.Stream;

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

    private static Stream<Arguments> should_classify_as_tall_given_height_is_greater_than_180cm() {
        return Stream.of(Arguments.of(181.0, true),
                Arguments.of(180.0, false),
                Arguments.of(179.0, false));
    }

    @ParameterizedTest
    @MethodSource
    void should_classify_as_tall_given_height_is_greater_than_180cm(double heightCentimeters,
                                                                    boolean expectedIsTall) {
        var ssn = "123456789";
        var heightInches = toInches(BigDecimal.valueOf(heightCentimeters));
        // NOTE: Alternative: var heightInches = BigDecimal.valueOf(71.25984252); // 181cm
        when(heightGateway.getHeightInches(ssn)).thenReturn(heightInches);

        var heightClassification = heightClassifier.isTall(ssn);

        assertThat(heightClassification).isEqualTo(expectedIsTall);
    }

    private static BigDecimal toInches(BigDecimal centimeters) {
        return centimeters.divide(Constants.CENTIMETERS_PER_INCH, MathContext.DECIMAL64);
    }
}
