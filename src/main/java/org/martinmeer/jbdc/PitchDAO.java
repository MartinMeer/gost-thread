package org.martinmeer.jbdc;

import org.martinmeer.utils.Connector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PitchDAO implements GostDAO<String>{

    @Override
    public String getValue(String sql) throws SQLException, IOException {
        int value = 0;
        int pitchIndex = 7;
        Connection conn = Connector.psqlConnection();
        sql = "SELECT dev, dev_array[?] FROM deviations WHERE dev = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, pitchIndex);
            pstmt.setString(2, deviation);
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
