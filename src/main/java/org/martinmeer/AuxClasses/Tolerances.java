package org.martinmeer.AuxClasses;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Tolerances implements DataMap<Map<Double, List<Double>>>{


    private final Map<Integer, Path> pathMap;
    private List<Double> pitches;
    private Scanner scanner;
    private List<Double> toleranceValues;


    public Tolerances(Map<Integer, Path> pathMap) {
        this.pathMap = pathMap;
    }


    @Override
    public Map<Double, ArrayList<Double>> getDataMap() throws IOException {
        getPitches();
        Map<Double, ArrayList<Double>> tolerancesMap = pitches.stream()
                .collect(Collectors.toMap(k -> k, v -> {
                    int givenPitch = k;
                    v = new ArrayList<>();
                    for (int i = 0; i < 3; i++) {
                        try {
                            toleranceValues(i);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        v.;
                    }


                });
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
