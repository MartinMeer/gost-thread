import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.martinmeer.io.InputConverter;
import org.martinmeer.params.Deviation;
import org.martinmeer.params.Pitch;
import org.martinmeer.utils.ParamNames;
import org.martinmeer.utils.PathMap;
import org.martinmeer.utils.PropertyManager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class MainTest {


    private static List<String> inputEn = List.of(
            "  М33хРh3P1.5- 7e6e - LH", //33, d2=, es=-0.067, ei_d2=-0.257, ei_d=-0.303
            "M33x1.5-6e",
            "M33-LH",
            "M33-LH"
    );
    private  static Map<ParamNames, String> inputMap;

    @BeforeAll
    public static void setUp() throws SQLException {
        PathMap pathMap = new PathMap();
        PropertyManager.setPathMap(pathMap);
        String input = inputEn.get(0);
        InputConverter inputConverter = new InputConverter(input);
        inputMap = inputConverter.generateInputMap();
    }

    @Test
    public void testDeviation_d2() throws SQLException, IOException {
        Pitch pitch = new Pitch(inputMap.get(ParamNames.PITCH));
        Deviation deviation = new Deviation(inputMap.get(ParamNames.TOLERANCE_ZONE), pitch);
        deviation.generateValue();
        assertThat(deviation.getPitchDiamDeviance()).isEqualTo(50);
    }
    @Test
    public void testDeviation_d() throws SQLException, IOException {
        Pitch pitch = new Pitch(inputMap.get(ParamNames.PITCH));
        Deviation deviation = new Deviation(inputMap.get(ParamNames.TOLERANCE_ZONE), pitch);
        deviation.generateValue();
        assertThat(deviation.getMajorDiamDeviance()).isEqualTo(50);
    }

}
