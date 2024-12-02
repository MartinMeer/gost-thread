package org.martinmeer.db;

import lombok.Getter;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class PathMap {

    @Getter
    private Map<String, Path> pathMap;
    private Path pathToPath;
    private PathToDB pathToDB;



    public void generate () {
        pathMap = new HashMap<String, Path>();
        pathMap.put("Pitches", Path.of("Pitches").toAbsolutePath().normalize());
        pathMap.put("Deviations", Path.of("Deviations.yml").toAbsolutePath().normalize());
        pathMap.put("ND-Tolerances", Path.of("nd-tolerances.yml").toAbsolutePath().normalize());
        pathMap.put("d2-Tolerances", Path.of(""));

    }

}
