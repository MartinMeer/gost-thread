import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.martinmeer.DataClasses.Pitches;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataClassTest {

    public static Path pitchesPath;

    @BeforeAll
    public static void setUp() {
        pitchesPath = Path.of("C:\\Users\\user\\IdeaProjects\\gost-thread\\src\\main\\resources\\Pitches");
    }


    @Test
    public void testPitches() throws IOException {
        Pitches pitches = new Pitches(pitchesPath);
        int size = 25;
        assertEquals(size, pitches.getPitches().size());
    }




}
