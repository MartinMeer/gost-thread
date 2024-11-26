package org.martinmeer.AuxClasses;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class Tolerances implements DataMap<Map<Double, List<Double>>>{


    private final Map<Integer, Path> pathMap;
    private List<Double> pitches;
    private Scanner scanner;
    private List<Double> toleranceValues;


    public Tolerances(Map<Integer, Path> pathMap) {
        this.pathMap = pathMap;
    }


    @Override
    public Map<Double, List<Double>> getDataMap() throws IOException {
        getPitches();
        Map<Double, List<Double>> tolerancesMap = new HashMap<>();
        return tolerancesMap;
    }

    private void getPitches() throws IOException {
        Path pitchesPath = Path.of("Pitches");
        scanner = new Scanner(pitchesPath);
        pitches = List.of(scanner.nextDouble());
    }

    private List<Double> toleranceValues(int toleranceIndex) throws IOException {
        scanner = new Scanner(pathMap.get(toleranceIndex));
        toleranceValues = List.of(scanner.nextDouble());
        return toleranceValues;
    }
}
