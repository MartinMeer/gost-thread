import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.martinmeer.utils.PathMap;
import org.martinmeer.utils.PropertyManager;

import java.io.IOException;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class JDBConnectTest {

    public static PropertyManager propertyManager;
    public static Map<String, Path> pathToProperties;
    public static PathMap pathMap;

    @BeforeAll
    public static void setUp() throws IOException {
        pathMap = new PathMap();
        pathToProperties = pathMap.pathToProperties();
        propertyManager = new PropertyManager(pathToProperties);
    }

    @Test
    public void testPropertyManager() {
        assertThat(propertyManager.getUrl()).isEqualTo("jdbc:postgresql://176.108.248.118:5432/otk");
        assertThat(propertyManager.getProperties().get("username")).isEqualTo("olegmm");
    }

    @Test
    public void testConnector() throws SQLException {
        var conn = DriverManager.getConnection(propertyManager.getUrl(),
                propertyManager.getProperties()
                        .get("username"),
                propertyManager.getProperties()
                        .get("password"));

        var sql = "SELECT * FROM pitches;";
        var statement = conn.createStatement();
        var set = statement.executeQuery(sql);
        StringBuilder str = new StringBuilder();

        while (set.next()) {
            str.append(set.getString(1)).append("\n");
        }
        conn.close();
        assertThat(str.toString()).isEqualTo("");


    }
}
