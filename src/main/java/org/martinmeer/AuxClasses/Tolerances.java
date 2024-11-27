package org.martinmeer.AuxClasses;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class Tolerances implements DataMap<Map<Double, List<Double>>>{


    private final Map<Integer, Path> pathMap;
    private Scanner scanner;
    private List<List<Double>> toleranceValues;


    public Tolerances(Map<Integer, Path> pathMap) {
        this.pathMap = pathMap;
    }


    @Override
    public TreeMap<Double, ArrayList<Double>> getDataMap() throws IOException {
        var pitches = getPitches();
        TreeMap<Double, ArrayList<Double>> tolerancesMap = new TreeMap<>();
        for (int i = 0; i < pitches.size(); i++) {
            Double key = pitches.get(i);
            ArrayList<Double> value = new ArrayList<>();
                for (int j = 1; j < pathMap.size(); j++) {
                value.add(toleranceValues(j).get(i));
            }
            tolerancesMap.put(key, value);
        }
        return tolerancesMap;
    }

    private

    private List<Double> getPitches() throws IOException {
        Path pitchesPath = Path.of("C:\\Users\\user\\IdeaProjects\\gost-thread\\src\\main\\resources\\Pitches");
        scanner = new Scanner(pitchesPath);
        return List.of(scanner.nextDouble());
    }

    private List<List<Double>> nomDiamToleranceValues() throws IOException {
        toleranceValues = new ArrayList<>();

        for (int i = 1; i < pathMap.size(); i++) {
            var entry = List.of(List.of(scanner.nextDouble()));
            var value;


            toleranceValues.put(key,value);


        }

        scanner = new Scanner(pathMap.get(toleranceIndex));
        toleranceValues = List.of(scanner.nextDouble());
        return toleranceValues;
    }
}
