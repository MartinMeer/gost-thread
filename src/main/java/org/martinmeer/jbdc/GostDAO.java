package org.martinmeer.jbdc;

import org.martinmeer.utils.ParamNames;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

public interface GostDAO<T> {
    //T getValue() throws SQLException, IOException;

    T getValue(Map<ParamNames, String> sql) throws SQLException, IOException;
}
