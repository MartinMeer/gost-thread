package org.martinmeer.db;

import org.martinmeer.utils.ParamNames;
import org.martinmeer.utils.PitchRanges;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class PathMap {

    public Map<ParamNames, Path> pathMapPDND() {
        Map<ParamNames, String> pathMap = new HashMap<>();
        pathMap.put(ParamNames.PITCHES, pathGen("Pitches"));
        pathMap.put(ParamNames.DEVIATIONS, pathGen("Deviations.yml"));
        pathMap.put(ParamNames.NDTOLERANCES, pathGen("nd-tolerances.yml"));
        return (Map<ParamNames, Path>) mapper(pathMap);
    }
    public Map<PitchRanges, Path> pathMap_d2() {
        Map<PitchRanges, String> pathMap = new HashMap<>();
        pathMap.put(PitchRanges.s1e1_4, pathGen("d2-tolerance-1-1.4.yml"));
        pathMap.put(PitchRanges.s1_4e2_8, pathGen("d2-tolerance-1.4-2.8.yml"));
        pathMap.put(PitchRanges.s2_8e5_6, pathGen("d2-tolerance-2.8-5.6.yml"));
        pathMap.put(PitchRanges.s5_6e11_2, pathGen("d2-tolerance-5.6-11.2.yml"));
        pathMap.put(PitchRanges.s11_2e22_4, pathGen("d2-tolerance-11.2-22.4.yml"));
        return (Map<PitchRanges, Path>) mapper(pathMap);
    }
    private Map<?, Path> mapper(Map<?, String> map) {
        return map.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, value -> Paths.get(value.getValue()).toAbsolutePath().normalize()));
    }
    private String pathGen(String fileName) {
        if (fileName.startsWith("d2")) {
            return "src/main/resources/d2-tolerances/";
        }
        return "src/main/resources/" + fileName;
    }
}
