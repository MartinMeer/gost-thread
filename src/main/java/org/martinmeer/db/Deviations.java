package org.martinmeer.db;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Deviations {
    private final Map<String, List<Double>> deviationsMap;
}
