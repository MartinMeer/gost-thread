import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.martinmeer.ParamNames;
import org.martinmeer.db.*;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InitTest {

    private static ParamNames dbNames;
    private static InMemoryDB imDB;
    private static Pitches pitches;
    private static Deviations deviations;
    private static NdTolerances ndTolerances;

    @BeforeAll
    public static void setUp() {
        imDB = new InMemoryDB();
        PathMap pathMap = new PathMap();
        imDB.initialize(pathMap);
        pitches = new Pitches(imDB.getPitchesList());
        deviations = new Deviations(imDB.getDeviationsMap());
        ndTolerances = new NdTolerances(imDB.getNdTolerancesMap());
    }

    @Test
    public void testInitPitches() throws IOException {
        int pitchesSize = 25;
        assertEquals(pitchesSize, pitches.getPitchesList().size());
    }
    @Test
    public void testInitDeviations() throws IOException {
        int deviationsSize = 5;
        int valueSize = 25;
        assertEquals(deviationsSize, deviations.getDeviationsMap().size());
        assertEquals(valueSize, deviations.getDeviationsMap().get("e").size());
    }
    @Test
    public void testInitNdTolerances() throws IOException {
        int ndTolerancesSize = 3;
        assertEquals(ndTolerancesSize, imDB.getNdTolerancesMap().size());
    }











}
