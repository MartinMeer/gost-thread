package org.martinmeer.utils;

import lombok.Getter;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

@Getter
public class PropertyManager {

    private final Map<String,Path> pathToProperties;
    private String url;
    private Map<String,String> properties;

    public PropertyManager(Map<String,Path> pathToProperties) throws IOException {
        this.pathToProperties = pathToProperties;
        generateProps();
    }
    private void generateProps() throws IOException {
        Map<String, String> urlMap = DbParser.parseYaml(pathToProperties.get("psql_url"));
        url = "jdbc:"
                + urlMap.get("subprotocol")
                + ":"
                + urlMap.get("subname")
                + urlMap.get("subsubname");
        properties = DbParser.parseYaml(pathToProperties.get("db_users"));
    }
}
