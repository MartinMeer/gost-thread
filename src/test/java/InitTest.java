import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.martinmeer.utils.ParamNames;
import org.martinmeer.db.*;
import org.martinmeer.utils.PitchRanges;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        int d2Tolerances_45_90_4_size = 8;

        assertEquals(d2Tolerances_45_90_4_size, d2Tolerances.getD2TolerancesMap().get(PitchRanges.s45e90).get(4.0).size());


    }











}
