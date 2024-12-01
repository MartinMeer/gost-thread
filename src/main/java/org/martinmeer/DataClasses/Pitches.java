package org.martinmeer.DataClasses;

import lombok.Getter;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class Pitches {

    private List<Double> pitches;

    public Pitches(Path path) throws IOException {
        pitches = parse(path);
    }

    public List<Double> getPitches() {
        return pitches;
    }

    public List<Double> parse(Path path) throws IOException {
        Scanner scanner = new Scanner(path);
        List<Double> pitchesList = new LinkedList<>();
        String[] data = scanner.nextLine().split(",");
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals("null")) {
                pitchesList.add(null);
            }
            pitchesList.add(Double.valueOf(data[i]));
        }
        scanner.close();
        return pitchesList;
    }
}
