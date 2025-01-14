package org.martinmeer.jbdc;

import org.martinmeer.utils.Connector;
import org.martinmeer.utils.ParamNames;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import static org.martinmeer.utils.Connector.psqlConnection;

public class PitchDAO implements GostDAO<String>{

    @Override
    public String getValue(Map<ParamNames, String> sql) throws SQLException, IOException {
        String parameter =  sql.get(ParamNames.NOMINAL_SIZE);
        String query = sql.get(ParamNames.DB_QUERY);
        String value = "";
        Connection conn = psqlConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, parameter);
            try (ResultSet rs = pstmt.executeQuery()) {
                while(rs.next()) {
                    value = rs.getString(sql.get(ParamNames.DB_ALIAS));
                }
            } catch (SQLException e) {
                System.out.println("PostgreSQL JDBC Driver not found");
                throw new RuntimeException(e);
            }
        }
        return value;
    }
}
