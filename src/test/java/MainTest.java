import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.martinmeer.imdb.Deviation;
import org.martinmeer.d2_calc.Diam_d2;
import org.martinmeer.imdb.InMemoryDB;
import org.martinmeer.imdb.Pitch;
import org.martinmeer.io.InputMap;
import org.martinmeer.utils.PathMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {


    private static PathMap pathMap;
    private static InMemoryDB inMemoryDB;
    private static String inputEn;
    private static InputMap inputMap;



    @BeforeAll
    public static void setUp() {
        inputEn = "M33x2-6e";
        pathMap = new PathMap();
        inputMap = new InputMap(inputEn);
        inMemoryDB = new InMemoryDB(pathMap);
    }

    @Test
    public void pitchTest() {
        Pitch pitch = new Pitch(inputMap.getPitch());
        assertThat(2).isEqualTo(pitch.getPitch());
    }

    @Test
    public void deviationTest() {
        Pitch pitch = new Pitch(inputMap.getPitch());
        Deviation deviation = new Deviation(pitch, inputMap
                .getDeviation())
                .setDeviation(inMemoryDB.getDeviationsMap(), inMemoryDB.getPitchesList());
        assertThat()

    }




    @Test
    public void d2_Test() {
        Pitch pitch = new Pitch();
        Diam_d2 diam_d2 = new Diam_d2();
        String expected = "31.701";
        String actual = diam_d2.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void esTest() {
        double expected = 0.071;
        double actual = 0;
        assertEquals(expected, actual);
    }
    @Test
    public void d_esTest() {
        double[] actual = {-0.071, -0.351};
        double[] expected = null;
        assertArrayEquals(expected, actual);
    }

    @Test
    public void ei_d2Test() {
        double[] actual = {-0.071, -0.241};
        double[] expected = null;
        assertEquals(expected, actual);
    }

    @Test
    public void d_measuringValuesTest() {

        double[] expected = {32.929, 32.649};
        double[] actual = null;
        assertArrayEquals(expected, actual);
    }

    @Test
    public void d2_measuringValuesTest() {
        double[] expected = {31.630, 31.460};
        double[] actual = null;
        assertArrayEquals(expected, actual);
    }
}
