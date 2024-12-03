package org.martinmeer.db;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class PathToFiles {


    public PathToFiles(DBNames dbNames) {
    }

    public Map<DBNames, Path> pathMapPDND() {
        Map<DBNames, String> pathMap = new HashMap<>();
        pathMap.put(DBNames.PITCHES, "resources/Pitches");
        pathMap.put(DBNames.DEVIATIONS, "resources/Deviations.yml");
        pathMap.put(DBNames.NDTOLERANCES, "resources/nd-tolerances.yml");
        return mapper(pathMap);
    }
    public Map<DBNames, Path> pathMapD2() {
        Map<DBNames, String> pathMap = new HashMap<>();
        pathMap.put(DBNames.D2_1_14, "resources/d2-tolerances/d2-tolerance-1-1.4.yml");
        pathMap.put(DBNames.D2_14_28, "resources/d2-tolerances/d2-tolerance-1.4-2.8.yml");
        pathMap.put(DBNames.D2_28_56, "resources/d2-tolerances/d2-tolerance-2.8-5.6.yml");
        pathMap.put(DBNames.D2_56_112, "resources/d2-tolerances/d2-tolerance-5.6-11.2.yml");
        pathMap.put(DBNames.D2_112_224, "resources/d2-tolerances/d2-tolerance-11.2-22.4.yml");
        return mapper(pathMap);
    }
    private Map<DBNames, Path> mapper( Map<DBNames, String> map) {
        return map.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, value -> Path.of(value.getValue()).toAbsolutePath().normalize()));
    }
}
