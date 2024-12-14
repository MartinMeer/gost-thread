import org.junit.jupiter.api.Test;
import org.martinmeer.db.PropertyManager;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class JDBConnectTest {

    @Test
    public void testProperties() throws IOException {
        PropertyManager propertyManager = new PropertyManager(Path.of("src/main/resources/psql"));
        Map propertyMap = propertyManager.connectPropertyMap();
        assertThat(propertyMap.get("username")).isEqualTo("olegmm");
    }
}
