package org.martinmeer.jbdc;

import org.martinmeer.params.Deviation;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ParamDAO implements DAO{

    private Connection conn;
    private String deviation;

    public ParamDAO(Connection conn, String deviation) {
        this.conn = conn;
        this.deviation = deviation;
    }

    @Override
    public Integer getValue() throws SQLException {
        Connection conn = Connector.psqlConnection()
        String sql = "SELECT dev, dev_arr FROM deviations WHERE dev = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, deviation);
        ResultSet rs = pstmt.executeQuery();
        return rs.getInt("dev_arr");
    }
}
