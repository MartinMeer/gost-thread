package org.martinmeer.jbdc;

import java.io.IOException;
import java.sql.SQLException;

public interface GostDAO<T> {
    //T getValue() throws SQLException, IOException;

    T getValue(String sql) throws SQLException, IOException;
}
