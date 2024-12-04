package org.martinmeer.db;

import lombok.Getter;
import org.martinmeer.ParamNames;
import org.martinmeer.utils.DbParser;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

@Getter
public class InMemoryDB {

    private List<Double> pitchesList;
    private Map<String, List<Double>> deviationsMap;
    private Map<Integer, List<Double>> ndTolerancesMap;

    public void initialize(PathMap pathMap) {
        pitchesList = DbParser.parseTxt(pathMap.pathMapPDND().get(ParamNames.PITCHES));
        deviationsMap = DbParser.parseYaml(pathMap.pathMapPDND().get(ParamNames.DEVIATIONS));
        ndTolerancesMap = DbParser.parseYaml(pathMap.pathMapPDND().get(ParamNames.NDTOLERANCES));
    }


}
