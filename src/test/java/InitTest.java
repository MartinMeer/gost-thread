import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.martinmeer.utils.ParamNames;
import org.martinmeer.db.*;
import org.martinmeer.utils.PitchRanges;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InitTest {

    private static ParamNames dbNames;
    private static Pitches pitches;
    private static Deviations deviations;
    private static NdTolerances ndTolerances;
    private static D2Tolerances d2Tolerances;

    @BeforeAll
    public static void setUp() {
        InMemoryDB imDB = new InMemoryDB();
        PathMap pathMap = new PathMap();
        imDB.initialize(pathMap);
        pitches = new Pitches(imDB.getPitchesList());
        deviations = new Deviations(imDB.getDeviationsMap());
        ndTolerances = new NdTolerances(imDB.getNdTolerancesMap());
        d2Tolerances = new D2Tolerances(imDB.getD2TolerancesMap());

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

    @Test
    public void testInitD2Tolerances() {
        int mapSize = 10;
        int d2Tolerances_45_90_4_size = 8;
        var innerMapKey = 2;
        Double innerMapValue = 90.0;

        assertEquals(mapSize, d2Tolerances.getD2TolerancesMap().get(PitchRanges.s45e90).size());
        assertTrue(d2Tolerances.getD2TolerancesMap().get(PitchRanges.s45e90).containsKey(innerMapKey));
        assertEquals(d2Tolerances_45_90_4_size, d2Tolerances.getD2TolerancesMap().get(PitchRanges.s45e90).get(0.5).size());
        assertEquals(innerMapValue, d2Tolerances.getD2TolerancesMap().get(PitchRanges.s45e90).get(innerMapKey).get(1));
        assertNull(d2Tolerances.getD2TolerancesMap().get(PitchRanges.s45e90).get(0.5).get(7));
    }











}
