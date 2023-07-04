package com.optivem.sandbox.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class HeightClassifierTest {

    private HeightPort heightPort;
    private HeightClassifier heightClassifier;

    private static Stream<Arguments> should_classify_as_tall_given_height_is_greater_than_180cm() {
        return Stream.of(
                Arguments.of(71.25984252 /* in = 181cm */, true),
                Arguments.of(70.86614173 /* in = 180cm */, false),
                Arguments.of(70.47244094 /* in = 179cm */, false));
    }

    @BeforeEach
    void setup() {
        heightPort = mock(HeightPort.class);
        heightClassifier = new HeightClassifier(heightPort);
    }

    @ParameterizedTest
    @MethodSource
    void should_classify_as_tall_given_height_is_greater_than_180cm(double heightInches,
                                                                    boolean expectedIsTall) {
        var ssn = "123456789";
        when(heightPort.getHeightInches(ssn)).thenReturn(BigDecimal.valueOf(heightInches));

        var isTall = heightClassifier.isTall(ssn);

        assertThat(isTall).isEqualTo(expectedIsTall);
    }
}
