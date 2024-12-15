package org.martinmeer.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;
import java.util.Properties;

public class Connector {

    public Connector(String driver, Map propertyMap) {
    }

    public Connection psqlConnection() {
        var conn = DriverManager.getConnection(propertyManager.getUrl(),
                propertyManager.getProperties()
                        .get("username"),
                propertyManager.getProperties()
                        .get("password"));
    }


}
