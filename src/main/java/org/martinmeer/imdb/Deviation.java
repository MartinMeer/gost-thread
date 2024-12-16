package org.martinmeer.imdb;

import java.util.List;
import java.util.Map;

public class Deviation {

    private final Pitch pitch;
    private final String inputDeviation;
    private int deviation;

    public Deviation(Pitch pitch, String inputDeviation) {
        this.pitch = pitch;
        this.inputDeviation = inputDeviation;
    }

    public Deviation setDeviation (Map<String, List<Number>> deviationsMap, List<Double> pitchesList) {
        var pitchIndex = pitchesList.indexOf(pitch.getPitch());
        var deviationSet = deviationsMap.get(inputDeviation);
        deviation = (int) deviationSet.get(pitchIndex);
        return this;
    }
}
