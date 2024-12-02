package org.martinmeer.db;

import lombok.Getter;
import org.martinmeer.utils.DbParser;

import java.nio.file.Path;
import java.util.Map;

@Getter
public class InMemoryDB {

    private Pitches pitches = new Pitches();
    private Deviations deviations;
    private NdTolerances ndTolerances;
    private D2Tolerances d2Tolerances;




    public void initialize(Path pathToDB) {
        Map<String, Path> pathMap = new PathMap().getPathMap();
        pitches.setPitchesList(DbParser.parseTxt(pathMap.get("Pitches")));
        d2Tolerances =
        deviations =
    }
}
