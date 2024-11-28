import org.junit.jupiter.api.Test;
import org.martinmeer.AuxClasses.Tolerances;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAuxMethods {

    @Test
    public void createTolerancesMapTest() throws IOException {
        Map<Integer, Path> pathMap = new HashMap<>();
        Map<Double, ArrayList<Double>> tolerancesMap;
        pathMap.put(4, Path.of("resources/nom-diam-tolerance-classes/nd-tolerances.yml"));
        pathMap.put(6, Path.of("resources/nom-diam-tolerance-classes/nd-tolerance6"));
        pathMap.put(9, Path.of("resources/nom-diam-tolerance-classes/nd-tolerance8"));
        Tolerances tolerances = new Tolerances(pathMap);
        tolerancesMap = tolerances.getDataMap();
        assertEquals(25, tolerancesMap.size());
    }



}
