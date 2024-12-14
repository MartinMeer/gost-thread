package org.martinmeer.db;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class PropertyManager {

    private final Path pathToProperties;

    public PropertyManager(Path pathToProperties1) throws IOException {
        this.pathToProperties = pathToProperties1;
    }
    public Map<String, String> connectPropertyMap() throws IOException {
        Scanner scanner = new Scanner(pathToProperties);
        List<String> properties = new ArrayList<>(3);
        while (scanner.hasNext()) {
            properties.add(scanner.nextLine());
        }
        return Map.of(
                "host", properties.get(0),
                "username", properties.get(1),
                "password", properties.get(2));

    }
}
