package org.martinmeer.db;

import lombok.Getter;
import lombok.Setter;

import java.util.*;
@Getter
@Setter
public class Pitches {

    private List<Double> pitchesList;

    public Pitches(List<Double> pitchesList) {
        this.pitchesList = pitchesList;
    }
}
