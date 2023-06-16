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

    @Test
    void should_classify_as_tall_given_height_is_greater_than_160cm() {
        var height = 161;
        var isTall = heightClassifier.isTall(height);
        assertThat(isTall).isTrue();
    }

    @Test
    void should_classify_as_tall_given_height_is_equal_to_160cm() {
        var height = 160;
        var isTall = heightClassifier.isTall(height);
        assertThat(isTall).isTrue();
    }

    @Test
    void should_classify_as_short_given_height_is_less_than_160cm() {
        var height = 159;
        var isTall = heightClassifier.isTall(height);
        assertThat(isTall).isFalse();
    }
}
