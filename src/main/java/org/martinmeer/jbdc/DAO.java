package org.martinmeer.jbdc;

import java.sql.SQLException;

public interface DAO<T> {
    T getValue() throws SQLException;
}
