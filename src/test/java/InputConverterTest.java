import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.martinmeer.io.InputConverter;
import org.martinmeer.utils.ParamNames;

import java.util.Map;

import static org.assertj.core.api.Assertions.as;
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
        inputRu = "  М33хРh3P0.45- 6е6G - LH";
        inputEnStar = "M33";
        inputRuStar = "М33*2-6е";
    }
    @Test
    public void testInputMap() {
        inputConverter = new InputConverter(inputEnStar);
        Map inputMap = inputConverter.generateInputMap();

        assertThat(inputMap.get(ParamNames.NOMINAL_DIAMETER)).isEqualTo("33");
        assertThat(inputMap.get(ParamNames.MULTISTART_TREAD)).isEqualTo(null); //"многозаходная резьба"
        assertThat(inputMap.get(ParamNames.PITCH)).isEqualTo(null);
        assertThat(inputMap.get(ParamNames.TOLERANCE_FIELD)).isEqualTo(null);
        assertThat(inputMap.get(ParamNames.DIRECTION)).isEqualTo(null); //"левая резьба"
    }

}