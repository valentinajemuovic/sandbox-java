package sandbox.core;

import com.optivem.sandbox.core.Height;
import com.optivem.sandbox.core.HeightClassifier;
import com.optivem.sandbox.core.HeightGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
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
        return Stream.of(
                Arguments.of(181, true),
                Arguments.of(180, false),
                Arguments.of(179, false));
    }

    @ParameterizedTest
    @MethodSource
    void should_classify_as_tall_given_height_is_greater_than_180cm(double heightCentimeters,
                                                                    boolean expectedIsTall) {
        var ssn = "123456789";
        when(heightGateway.getHeight(ssn)).thenReturn(Height.ofCentimeters(heightCentimeters));

        var isTall = heightClassifier.isTall(ssn);

        assertThat(isTall).isEqualTo(expectedIsTall);
    }
}
