package org.martinmeer.imdb;

import lombok.Getter;
import org.martinmeer.utils.PathMap;
import org.martinmeer.utils.ParamNames;
import org.martinmeer.utils.DbParser;
import org.martinmeer.utils.PitchRanges;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
public class InMemoryDB<T> {

    private PathMap pathMap;
    private List<Double> pitchesList;
    private Map<String, List<Number>> deviationsMap;
    private Map<Integer, List<Number>> d_TolerancesMap;
    private Map<PitchRanges, Map<Number, List<Number>>> d2_TolerancesMap;

    public InMemoryDB(PathMap pathMap) {
        this.pathMap = pathMap;
    }

    public void initializeFileDB() {
        pitchesList = DbParser.parseTxt(pathMap.pathMapPitch_Deviance_d().get(ParamNames.PITCHES));
        deviationsMap = DbParser.parseYaml(pathMap.pathMapPitch_Deviance_d().get(ParamNames.DEVIATIONS));
        d_TolerancesMap = DbParser.parseYaml(pathMap.pathMapPitch_Deviance_d().get(ParamNames.TOLERANCES_d));
        d2_TolerancesMap = pathMap.pathMap_d2().entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, value -> DbParser.parseYaml(value.getValue())));
    }

    public void initializeJDBC() {

    }
}
