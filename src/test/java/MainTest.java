import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.martinmeer.io.InputConverter;
//import org.martinmeer.params.Deviation;
import org.martinmeer.params.InputMap;
import org.martinmeer.params.NominalSize;
import org.martinmeer.params.Pitch;
import org.martinmeer.utils.ParamNames;
import org.martinmeer.utils.PathMap;
import org.martinmeer.utils.PropertyManager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
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
    private static InputMap inputMap;
    private static InputConverter inputConverter;

    @BeforeAll
    public static void setUp() throws SQLException {
        PathMap pathMap = new PathMap();
        //PropertyManager.setPathMap(pathMap);
        String input = inputEn.get(0);
        inputConverter = new InputConverter(input);
        inputMap = new InputMap(inputConverter.generateInputMap());
    }

    @Test
    public void testNominalSize() {
        NominalSize nominalSize = new NominalSize(inputMap.getParameter(ParamNames.NOMINAL_SIZE));
        assertThat(nominalSize.getNominalSize()).isEqualTo("33");
    }

    @Test
    public void testPitch() {


    }

    /*@Test
    public void testDeviation_d2() throws SQLException, IOException {
        Pitch pitch = new Pitch(inputMap.getPitch());
        Deviation deviation = new Deviation(inputMap.get(ParamNames.TOLERANCE_ZONE), pitch);
        deviation.generateValue();
        assertThat(deviation.getPitchDiamDeviance()).isEqualTo(50);
    }
    /*@Test
    public void testDeviation_d() throws SQLException, IOException {
        Pitch pitch = new Pitch(inputMap.get(ParamNames.PITCH));
        Deviation deviation = new Deviation(inputMap.get(ParamNames.TOLERANCE_ZONE), pitch);
        deviation.generateValue();
        assertThat(deviation.getMajorDiamDeviance()).isEqualTo(50);
    }

    public static String indices(List<Double> pitches, List<Double> givenPitches) {
        //List<Integer> indices = new ArrayList<>();
        StringBuilder sb = new StringBuilder("(");
        givenPitches.forEach(e -> sb.append(pitches.indexOf(e) + 1).append("), ("));
        return sb.toString();
    }*/

}
