package org.martinmeer.utils;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;


public class PathMap {

    //private Map<String, Path> pathToProperties;


    public Map<String, Path> getPathToProperties() {
        Map<String, Path> pathToProperties = new HashMap<>();
        pathToProperties.put("psql_url", pathGen("psql_url.yml"));
        pathToProperties.put("db_users", pathGen("db_users.yml"));
        return pathToProperties;
    }

    private Path pathGen(String fileName) {
        if (fileName.startsWith("d2")) {
            return Path.of("src/main/resources/d2-tolerances/" + fileName)
                    .toAbsolutePath()
                    .normalize();
        }
        return Path.of("src/main/resources/" + fileName)
                .toAbsolutePath()
                .normalize();
    }

    public Map<ParamNames, Path> pathMapPitch_Deviance_d() {
        Map<ParamNames, Path> pathMap = new HashMap<>();
        pathMap.put(ParamNames.PITCHES, pathGen("Pitches"));
        pathMap.put(ParamNames.DEVIATIONS, pathGen("Deviations.yml"));
        pathMap.put(ParamNames.TOLERANCES_d, pathGen("d-tolerances.yml"));
        return pathMap;
    }
    public Map<PitchRanges, Path> pathMap_d2() {
        Map<PitchRanges, Path> pathMap = new HashMap<>();
        pathMap.put(PitchRanges.s1e1_4, pathGen("d2-tolerance-1-1.4.yml"));
        pathMap.put(PitchRanges.s1_4e2_8, pathGen("d2-tolerance-1.4-2.8.yml"));
        pathMap.put(PitchRanges.s2_8e5_6, pathGen("d2-tolerance-2.8-5.6.yml"));
        pathMap.put(PitchRanges.s5_6e11_2, pathGen("d2-tolerance-5.6-11.2.yml"));
        pathMap.put(PitchRanges.s11_2e22_4, pathGen("d2-tolerance-11.2-22.4.yml"));
        pathMap.put(PitchRanges.s22_4e45, pathGen("d2-tolerance-22.4-45.yml"));
        pathMap.put(PitchRanges.s45e90, pathGen("d2-tolerance-45-90.yml"));
        return pathMap;
    }

}
