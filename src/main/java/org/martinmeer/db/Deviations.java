package org.martinmeer.db;

import java.util.List;
import java.util.Map;
import lombok.Getter;

@Getter
public class Deviations {

    private Map<String, List<Double>> deviationsMap;

    public Deviations(Map<String, List<Double>> deviationsMap) {

    }
}
