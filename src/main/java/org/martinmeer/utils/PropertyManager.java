package org.martinmeer.utils;

import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;


@Getter
@Setter
public class PropertyManager {

    private static PathMap pathMap;

    /*private PropertyManager(PathMap pathMap) {
        this.pathMap = pathMap;
    }*/

    public static Map<String, String> generateProps() throws IOException {
        Map<String,Path> pathToProperties = pathMap.getPathToProperties();
        Map<String, String> connSettings = new HashMap<>(DbParser.parseYaml(pathToProperties.get("db_users")));
        Map<String, String> url = DbParser.parseYaml(pathToProperties.get("psql_url"));
        connSettings.put("url", "jdbc:"
                + url.get("subprotocol")
                + ":"
                + url.get("subname")
                + url.get("subsubname"));
        return connSettings;
    }

    /*public static void setPathMap(PathMap pathMap) {
        PropertyManager.pathMap = pathMap;
    }*/
}
