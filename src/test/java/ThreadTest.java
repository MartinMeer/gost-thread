import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThreadTest {




    @Test
    public void threadGenTestGenerate() throws IOException {
        Path fixture = Path.of("treadGenStringOutput");
        ThreadGen tg = new ThreadGen("M33x2-6e");
        String expected = Files.readString(fixture);
        String actual = tg.generateOutput();
        assertEquals(expected, actual);
    }


}
