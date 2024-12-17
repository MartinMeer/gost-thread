package org.martinmeer.jbdc;

import org.martinmeer.utils.PropertyManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

    private static Connection connection;

    public static Connection psqlConnection(PropertyManager propertyManager) throws SQLException {
        var connSettings = propertyManager.getConnSettings();
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                System.out.println("PostgeSQL JDBC Driver not found");
                throw new RuntimeException(e);
            }
            connection = DriverManager.getConnection(
                    connSettings.get("url"),
                    connSettings.get("username"),
                    connSettings.get("password"));
        }
        return connection;
    }
}
