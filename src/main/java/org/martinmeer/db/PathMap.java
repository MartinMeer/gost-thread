package org.martinmeer.db;

import org.martinmeer.ParamNames;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class PathMap {

    private ParamNames paramNames;


    //public PathMap(ParamNames dbNames) {
    //}

    public Map<ParamNames, Path> pathMapPDND() {
        Map<ParamNames, String> pathMap = new HashMap<>();
        pathMap.put(ParamNames.PITCHES, "resources/Pitches");
        pathMap.put(ParamNames.DEVIATIONS, "resources/Deviations.yml");
        pathMap.put(ParamNames.NDTOLERANCES, "resources/nd-tolerances.yml");
        return mapper(pathMap);
    }
    public Map<ParamNames, Path> pathMapD2() {
        Map<ParamNames, String> pathMap = new HashMap<>();
        pathMap.put(ParamNames.D2_1_14, "resources/d2-tolerances/d2-tolerance-1-1.4.yml");
        pathMap.put(ParamNames.D2_14_28, "resources/d2-tolerances/d2-tolerance-1.4-2.8.yml");
        pathMap.put(ParamNames.D2_28_56, "resources/d2-tolerances/d2-tolerance-2.8-5.6.yml");
        pathMap.put(ParamNames.D2_56_112, "resources/d2-tolerances/d2-tolerance-5.6-11.2.yml");
        pathMap.put(ParamNames.D2_112_224, "resources/d2-tolerances/d2-tolerance-11.2-22.4.yml");
        return mapper(pathMap);
    }
    private Map<ParamNames, Path> mapper(Map<ParamNames, String> map) {
        return map.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, value -> Paths.get(value.getValue()).toAbsolutePath().normalize()));
    }
}
