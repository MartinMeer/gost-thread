package org.martinmeer.db;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class Tolerances_d {
    private Map<Integer, List<Number>> d_TolerancesMap;
}
