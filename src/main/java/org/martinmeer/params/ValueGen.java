package org.martinmeer.params;

import java.io.IOException;
import java.sql.SQLException;

public interface ValueGen {

    void getValue() throws SQLException, IOException;
}
