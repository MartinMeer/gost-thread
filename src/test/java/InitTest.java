import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.martinmeer.utils.ParamNames;
import org.martinmeer.db.*;
import org.martinmeer.utils.PitchRanges;

import static org.junit.jupiter.api.Assertions.*;

public class InitTest {

    private static ParamNames dbNames;
    private static Pitches pitches;
    private static Deviations deviations;
    private static Tolerances_d tolerancesD;
    private static Tolerances_d2 tolerancesD2;

    @BeforeAll
    public static void setUp() {
        InMemoryDB imDB = new InMemoryDB();
        PathMap pathMap = new PathMap();
        imDB.initialize(pathMap);
        pitches = new Pitches(imDB.getPitchesList());
        deviations = new Deviations(imDB.getDeviationsMap());
        tolerancesD = new Tolerances_d(imDB.getD_TolerancesMap());
        tolerancesD2 = new Tolerances_d2(imDB.getD2_TolerancesMap());

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
        assertEquals(ndTolerancesSize, tolerancesD
                .getD_TolerancesMap().size());
        assertEquals(valueSize, tolerancesD
                .getD_TolerancesMap().get(6).size());
    }

    @Test
    public void testInitD2Tolerances() {
        int mapSize = 10;
        int d2Tolerances_45_90_4_size = 8;
        var innerMapKey = 1.5;
        var innerMapValue = 100;

        assertEquals(mapSize, tolerancesD2
                .getD2_TolerancesMap()
                .get(PitchRanges.s45e90)
                .size());
        assertTrue(tolerancesD2
                .getD2_TolerancesMap()
                .get(PitchRanges.s45e90)
                .containsKey(innerMapKey));
        assertEquals(d2Tolerances_45_90_4_size, tolerancesD2
                .getD2_TolerancesMap()
                .get(PitchRanges.s45e90)
                .get(0.5).size());
        assertEquals(innerMapValue, tolerancesD2
                .getD2_TolerancesMap()
                .get(PitchRanges.s45e90)
                .get(innerMapKey)
                .get(0));
        assertNull(tolerancesD2
                .getD2_TolerancesMap()
                .get(PitchRanges.s45e90)
                .get(0.5).get(7));
    }
}
