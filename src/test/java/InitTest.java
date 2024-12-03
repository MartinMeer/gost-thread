import org.junit.jupiter.api.Test;
import org.martinmeer.ParamNames;
import org.martinmeer.db.InMemoryDB;
import org.martinmeer.db.PathMap;
import org.martinmeer.db.Pitches;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InitTest {

    public static ParamNames dbNames;

    @Test
    public void testInitialize() throws IOException {
        InMemoryDB imDB = new InMemoryDB();
        PathMap pathMap = new PathMap();
        imDB.initialize(pathMap);
        Pitches pitches = new Pitches(imDB.getPitchesList());
        int pitchesSize = 25;
        int deviationsSize = 5;
        int ndTolerancesSize = 3;
        int d2TolerancesSize = 5;
        assertEquals(pitchesSize, pitches.getPitchesList().size());
        //assertEquals(deviationsSize, imDB.getDeviations().getDeviationsList().size());
        //assertEquals(ndTolerancesSize, imDB.getNdTolerances().getNdTolerancesMap().size());
        //assertEquals(d2TolerancesSize, imDB.getD2Tolerances().getD2TolerancesMap().size());
    }







}
