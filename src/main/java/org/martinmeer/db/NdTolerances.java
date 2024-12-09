package org.martinmeer.db;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class NdTolerances {
    private Map<Integer, List<Number>> ndTolerancesMap;
}
