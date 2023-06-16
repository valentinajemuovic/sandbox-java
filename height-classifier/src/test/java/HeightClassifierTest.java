import com.optivem.sandbox.HeightClassification;
import com.optivem.sandbox.HeightClassifier;
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
    void should_classify_as_tall_given_height_is_greater_than_180cm() {
        var height = 181;
        var heightClassification = heightClassifier.classify(height);
        assertThat(heightClassification).isEqualTo(HeightClassification.Tall);
    }

    @ParameterizedTest
    @ValueSource(ints = { 160, 161, 179, 180 })
    void should_classify_as_medium_given_height_is_between_160cm_and_180cm_inclusive(int height) {
        var heightClassification = heightClassifier.classify(height);
        assertThat(heightClassification).isEqualTo(HeightClassification.Medium);
    }

    @Test
    void should_classify_as_short_given_height_is_less_than_160cm() {
        var height = 159;
        var heightClassification = heightClassifier.classify(height);
        assertThat(heightClassification).isEqualTo(HeightClassification.Short);
    }
}
