import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.martinmeer.BasicPitchDiam;
import org.martinmeer.Deviation;
import org.martinmeer.MeasuringValues;
import org.martinmeer.ThreadMeasuringGen;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThreadTest {

    public static BasicPitchDiam d2;

    @BeforeAll
    public static void setUp() {
        d2 = new BasicPitchDiam(33);
    }

    @Test
    public void basicPitchDiamTest() {
        double expected = 36.630;
        double actual = d2.generate();
        assertEquals(expected, actual);
    }

    @Test
    public void deviationTest() {
        double d2 = d2.generate();
        Deviation e = new Deviation(d2);
        double[] expected = {-0.071, -0.241};
        double[] actual = e.generate();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void measuringValuesTest() {
        double d2 = d2.generate();
        MeasuringValues mv = new MeasuringValues(d2);
        double[] expected = {31.630, 31.460};
        double[] actual = mv.generate();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void threadGenTestGenerate() throws IOException {
        Path fixture = Path.of("treadGenStringOutput");
        ThreadMeasuringGen tmg = new ThreadMeasuringGen("M33x2-6e");
        Map<String, Double> threadMeasuringValues = tmg.generateOutput();
        OutputGen outputGen = new OutputGen(threadMeasuringValues);
        String expected = Files.readString(fixture);
        String actual = outputGen.print();
        assertEquals(expected, actual);
    }
}
