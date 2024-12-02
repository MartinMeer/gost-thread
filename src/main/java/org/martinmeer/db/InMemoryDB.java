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




    public void initialize(PathMap pathMap) {
        pitchesList = DbParser.parseTxt(pathMap.pathMapPDND().get(ParamNames.PITCHES));

    }
}
