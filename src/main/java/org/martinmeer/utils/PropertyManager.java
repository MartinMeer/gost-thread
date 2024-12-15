package org.martinmeer.utils;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class PropertyManager {

    public static Map<String, String> generateProps(Map<String,Path> pathToProperties) throws IOException {
        Map<String, String> connSettings = new HashMap<>(DbParser.parseYaml(pathToProperties.get("db_users")));
        Map<String, String> url = DbParser.parseYaml(pathToProperties.get("psql_url"));
        connSettings.put("url", "jdbc:"
                + url.get("subprotocol")
                + ":"
                + url.get("subname")
                + url.get("subsubname"));
        return connSettings;
    }
}
