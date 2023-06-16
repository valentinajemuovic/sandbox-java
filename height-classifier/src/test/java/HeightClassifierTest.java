import com.optivem.sandbox.HeightClassifier;
import org.assertj.core.internal.BigDecimals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class HeightClassifierTest {

    private HeightClassifier heightClassifier;

    @BeforeEach
    void setup() {
        heightClassifier = new HeightClassifier();
    }

    @ParameterizedTest
    @ValueSource(ints = { 161, 200 })
    void should_classify_as_tall_given_height_is_greater_than_160cm(int height) {
        var isTall = heightClassifier.isTall(height);
        assertThat(isTall).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = { 160, 150 })
    void should_classify_as_short_given_height_is_less_than__or_equal_to_160cm(int height) {
        var isTall = heightClassifier.isTall(height);
        assertThat(isTall).isFalse();
    }
}
