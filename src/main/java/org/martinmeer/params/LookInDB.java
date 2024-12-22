package org.martinmeer.params;

import java.io.IOException;
import java.sql.SQLException;

public interface LookInDB<T> {
    T sendQuery(String data) throws SQLException, IOException;
}
