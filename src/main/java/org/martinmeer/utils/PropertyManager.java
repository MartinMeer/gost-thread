package org.martinmeer.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;


@Getter
public class PropertyManager {

    private final PathMap pathMap;
    private Map<String, String> connSettings;

    public PropertyManager(PathMap pathMap) {
        this.pathMap = pathMap;
    }

    public Map<String, String> generateProps() throws IOException {
        Map<String,Path> pathToProperties = pathMap.pathToProperties();
        connSettings = new HashMap<>(DbParser.parseYaml(pathToProperties.get("db_users")));
        Map<String, String> url = DbParser.parseYaml(pathToProperties.get("psql_url"));
        connSettings.put("url", "jdbc:"
                + url.get("subprotocol")
                + ":"
                + url.get("subname")
                + url.get("subsubname"));
        return connSettings;
    }
}
