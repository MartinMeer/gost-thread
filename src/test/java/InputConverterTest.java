import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.martinmeer.io.InputConverter;
import org.martinmeer.params.ParamMap;
import org.martinmeer.utils.Namespace;

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
        ParamMap paramMap = new ParamMap(inputConverter.generateInputMap());


        assertThat(paramMap.getParameter(Namespace.NOMINAL_SIZE)).isEqualTo("2.25");
        assertThat(paramMap.getParameter(Namespace.MULTISTART_TREAD)).isEqualTo("многозаходная резьба"); //"многозаходная резьба"
        assertThat(paramMap.getParameter(Namespace.PITCH)).isEqualTo("0.45");
        assertThat(paramMap.getParameter(Namespace.TOLERANCE_ZONE)).isEqualTo("6e6g");
        assertThat(paramMap.getParameter(Namespace.DIRECTION)).isEqualTo("левая резьба"); //"левая резьба"
    }

}