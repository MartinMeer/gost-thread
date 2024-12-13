import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.martinmeer.imdb.InMemoryDB;
import org.martinmeer.db.PathMap;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThreadTest {


    private static PathMap pathMap;
    private static InMemoryDB inMemoryDB;
    private static String inputEn;



    @BeforeAll
    public static void setUp() {
        pathMap = new PathMap();
        inMemoryDB = new InMemoryDB(pathMap);
        inputEn = "M33x2-6e";
    }



    @Test
    public void d2_Test() {

        double expected = 31.701;
        double actual = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void deviationTest() {
        double expected = 0.071;
        double actual = 0;
        assertEquals(expected, actual);
    }
    @Test
    public void d_TolerancesTest() {
        double[] actual = {-0.071, -0.351};
        double[] expected = null;
        assertArrayEquals(expected, actual);
    }

    @Test
    public void d2_TolerancesTest() {
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
