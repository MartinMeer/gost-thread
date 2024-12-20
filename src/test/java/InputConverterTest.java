import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.martinmeer.io.InputConverter;
import org.martinmeer.utils.ParamNames;

import java.util.Map;

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
    @Test
    public void testInputMap() {
        inputConverter = new InputConverter(inputRu);
        Map inputMap = inputConverter.generateInputMap();
        assertThat(inputMap.get(ParamNames.DIRECTION)).isEqualTo("левая резьба");
        assertThat(inputMap.get(ParamNames.NOMINAL_DIAMETER)).isEqualTo("33");
    }

}