package org.martinmeer.db;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class PathMap {

    @Getter
    private Map<String, Path> pathMap;
    private Path pathToPath;
    private DBNames dbNames;
    private Map<DBNames, String> pathMapPDND;
    private Map<DBNames, String> pathMapD2;


    public void generate () {
        PathToFiles pathToFiles = new PathToFiles(dbNames);
        Map<DBNames, String> pathMapPDND = pathToFiles.pathMapPDND();
        Map<DBNames, String> pathMapD2 = pathToFiles.pathMapD2();

        pathMap = new HashMap<String, Path>();
        pathMap.put("Pitches", Path.of("Pitches").toAbsolutePath().normalize());
        pathMap.put("Deviations", Path.of("Deviations.yml").toAbsolutePath().normalize());
        pathMap.put("ND-Tolerances", Path.of("nd-tolerances.yml").toAbsolutePath().normalize());
        pathMap.put("d2-Tolerances", Path.of(""));

    }

}
