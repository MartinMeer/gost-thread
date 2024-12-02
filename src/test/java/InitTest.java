import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.martinmeer.db.InMemoryDB;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InitTest {

    public static Path pathToPath;

    @BeforeAll
    public static void setUp() {
        pathToPath = Path.of("C:\\Users\\user\\IdeaProjects\\gost-thread\\src\\main\\resources\\Path");
    }


    @Test
    public void testInitialize() throws IOException {
        InMemoryDB imDB = new InMemoryDB();
        imDB.initialize(pathToPath);
        int pitchesSize = 25;
        int deviationsSize = 5;
        int ndTolerancesSize = 3;
        int d2TolerancesSize = 5;
        assertEquals(pitchesSize, imDB.getPitches().getPitchesList().size());
        assertEquals(deviationsSize, imDB.getDeviations().getDeviationsList().size());
        assertEquals(ndTolerancesSize, imDB.getNdTolerances().getNdTolerancesMap().size());
        assertEquals(d2TolerancesSize, imDB.getD2Tolerances().getD2TolerancesMap().size());
    }







}
