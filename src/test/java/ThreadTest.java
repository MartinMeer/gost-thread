import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.martinmeer.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThreadTest {

    private static String inputEn;
    private static String inputRu;


    @BeforeAll
    public static void setUp() {
        inputEn = "M33x2-6e";
        inputRu = "М33х2-6е";
    }

    @Test
    public void d_Test() {
        double expected = 33;
        double actual = 0;
        assertEquals(expected, actual);
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
    public void initTest() {

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
