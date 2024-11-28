import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.martinmeer.*;
import org.martinmeer.AuxClasses.BasicPitchDiam;

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
        d2 = new BasicPitchDiam(8, 1.2);
    }

    @Test
    public void basicPitchDiamTest() {
        double expected = 31.701;
        double actual = d2.generate();
        assertEquals(expected, actual);
    }

    @Test
    public void deviationTest() {
        double nominalPitchDiam = d2.generate();
        DeviationsGen e = new DeviationsGen(nominalPitchDiam);
        double[] expected = {-0.071, -0.241};
        double[] actual = e.generate();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void measuringValuesTest() {
        double nominalPitchDiam = d2.generate();
        MeasuringValuesGen mv = new MeasuringValuesGen(nominalPitchDiam);
        double[] expected = {31.630, 31.460};
        double[] actual = mv.generate();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void threadGenTestGenerate() throws IOException {
        Path fixture = Path.of("treadGenStringOutput");
        ThreadMeasuringGen tmg = new ThreadMeasuringGen("M33x2-6e");
        Map<String, Double> threadMeasuringValues = tmg.generateMapOfMeasuringVal();
        OutputGen outputGen = new OutputGen(threadMeasuringValues);
        String expected = Files.readString(fixture);
        String actual = outputGen.print();
        assertEquals(expected, actual);
    }
}
