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
        inputRu = "  М2.25хРh3P0,45- 6е6G - LH";
        inputEnStar = "M33";
        inputRuStar = "М33*2-6е";
    }
    @Test
    public void testInputMap() {
        inputConverter = new InputConverter(inputRu);
        Map inputMap = inputConverter.generateInputMap();

        assertThat(inputMap.get(ParamNames.NOMINAL_SIZE)).isEqualTo("2.25");
        assertThat(inputMap.get(ParamNames.MULTISTART_TREAD)).isEqualTo("многозаходная резьба"); //"многозаходная резьба"
        assertThat(inputMap.get(ParamNames.PITCH)).isEqualTo("0.45");
        assertThat(inputMap.get(ParamNames.TOLERANCE_ZONE)).isEqualTo("6e6g");
        assertThat(inputMap.get(ParamNames.DIRECTION)).isEqualTo("левая резьба"); //"левая резьба"
    }

}