/*
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.martinmeer.d2_calc.Diam_d2;
import org.martinmeer.imdb.InMemoryDB;
import org.martinmeer.imdb.Pitch;
import org.martinmeer.io.InputMap;
import org.martinmeer.jbdc.Connector;
import org.martinmeer.utils.PathMap;
import org.martinmeer.utils.PropertyManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {


    private static PathMap pathMap;
    private static InMemoryDB inMemoryDB;
    private static String inputEn;
    private static InputMap inputMap;
    private static PropertyManager propertyManager;
    private static Connection connection;



    @BeforeAll
    public static void setUp() throws SQLException {
        pathMap = new PathMap();
        //inMemoryDB = new InMemoryDB(pathMap);
        inputEn = "M33x2-6e";
        inputMap = new InputMap(inputEn);
        propertyManager = new PropertyManager(pathMap);
        connection = Connector.psqlConnection(propertyManager);
    }



    @Test
    public void d2_Test() {
        //Pitch pitch = new Pitch();
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
*/
