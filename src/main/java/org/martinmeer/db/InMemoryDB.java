package org.martinmeer.db;

import lombok.Getter;
import org.martinmeer.utils.ParamNames;
import org.martinmeer.utils.DbParser;
import org.martinmeer.utils.PitchRanges;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
public class InMemoryDB {

    private List<Double> pitchesList;
    private Map<String, List<Double>> deviationsMap;
    private Map<Integer, List<Double>> ndTolerancesMap;
    private Map<PitchRanges, Map<Number, List<Double>>> d2TolerancesMap;

    public void initialize(PathMap pathMap) {
        pitchesList = DbParser.parseTxt(pathMap.pathMapPDND().get(ParamNames.PITCHES));
        deviationsMap = DbParser.parseYaml(pathMap.pathMapPDND().get(ParamNames.DEVIATIONS));
        ndTolerancesMap = DbParser.parseYaml(pathMap.pathMapPDND().get(ParamNames.NDTOLERANCES));
        d2TolerancesMap = pathMap.pathMap_d2().entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, value -> DbParser.parseYaml(value.getValue())));
    }
}
