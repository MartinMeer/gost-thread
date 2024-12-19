import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.martinmeer.io.InputConverter;

import static org.assertj.core.api.Assertions.assertThat;

public class InputConverterTest {

    private static InputConverter inputConverter;
    private static String inputEn;
    private static String inputRu;
    private static String inputEnStar;
    private static String inputRuStar;

    @BeforeAll
    public static void setUp() {
        inputEn = "M33x2-6e";
        inputRu = "  М33хРh3P12- 6е6G - LH";
        inputEnStar = "M33*2-6e";
        inputRuStar = "М33*2-6е";
    }
    /*@Test
    public void testNormalize() {
        inputConverter = new InputConverter(inputRu);
        assertThat(inputConverter.normalize(inputRu)).isEqualTo("e");
    }*/

}
