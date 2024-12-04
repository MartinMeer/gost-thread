import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.martinmeer.ParamNames;
import org.martinmeer.db.*;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InitTest {

    private static ParamNames dbNames;
    private static Pitches pitches;
    private static Deviations deviations;
    private static NdTolerances ndTolerances;

    @BeforeAll
    public static void setUp() {
        InMemoryDB imDB = new InMemoryDB();
        PathMap pathMap = new PathMap();
        imDB.initialize(pathMap);
        pitches = new Pitches(imDB.getPitchesList());
        deviations = new Deviations(imDB.getDeviationsMap());
        ndTolerances = new NdTolerances(imDB.getNdTolerancesMap());
    }

    @Test
    public void testInitPitches() {
        int pitchesSize = 25;
        assertEquals(pitchesSize, pitches.getPitchesList().size());
    }
    @Test
    public void testDeviationsMap() {
        assertTrue(deviations.getDeviationsMap().containsKey("d"));
    }

    @Test
    public void testInitDeviations() {
        int deviationsSize = 5;
        int valueSize = 25;
        assertEquals(deviationsSize, deviations.getDeviationsMap().size());
        assertEquals(valueSize, deviations.getDeviationsMap().get("e").size());
        assertTrue(deviations.getDeviationsMap().get("e").contains(null));
    }
    @Test
    public void testInitNdTolerances() {
        int ndTolerancesSize = 3;
        int valueSize = 25;
        assertEquals(ndTolerancesSize, ndTolerances.getNdTolerancesMap().size());
        assertEquals(valueSize, ndTolerances.getNdTolerancesMap().get(6).size());
    }











}
