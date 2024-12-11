import org.junit.jupiter.api.BeforeAll;
import org.martinmeer.db.InMemoryDB;
import org.martinmeer.db.PathMap;
import org.martinmeer.io.InputConverter;

public class InputConverterTest {

    private static InputConverter inputConverter;
    private static String inputEn;
    private static String inputRu;
    private static String inputEnStar;
    private static String inputRuStar;

    @BeforeAll
    public static void setUp() {
        inputEn = "M33x2-6e";
        inputRu = "М33х2-6е";
        inputEnStar = "M33*2-6e";
        inputRuStar = "М33*2-6е";
    }

}
