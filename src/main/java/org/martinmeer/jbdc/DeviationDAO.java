package org.martinmeer.jbdc;


import org.martinmeer.utils.Connector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeviationDAO implements DAO {

    //private Connection conn;
    private final String deviation;

    public DeviationDAO(String deviation) {
        //this.conn = conn;
        this.deviation = deviation;
    }

    @Override
    public Integer getValue() throws SQLException, IOException {
        int value = 0;
        Connection conn = Connector.psqlConnection();
        String sql = "SELECT dev, dev_array[7] FROM deviations WHERE dev = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, deviation);
            try (ResultSet rs = pstmt.executeQuery()) {
                while(rs.next()) {
                    value = rs.getInt("dev_array");
                }
            } catch (SQLException e) {
                System.out.println("PostgeSQL JDBC Driver not found");
                throw new RuntimeException(e);
            }
        }
        return value;
    }
}