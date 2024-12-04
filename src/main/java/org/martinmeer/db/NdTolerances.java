package org.martinmeer.db;

import lombok.Getter;

import java.util.Map;

@Getter
public class NdTolerances {

    private Map<String, Double> ndTolerancesMap;

    public NdTolerances(Map<String, Double> ndTolerancesMap) {

    }
}
