package org.martinmeer.jbdc;

import org.martinmeer.imdb.Pitch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class PitchDAO implements DAO<Double>{

    private Connection conn;
    private Pitch pitch;

    public PitchDAO(Connection conn, Pitch pitch) {
        this.conn = conn;
        this.pitch = pitch;
    }

    @Override
    public Double getValue() throws SQLException {
        String sql = "SELECT pitch FROM pitches WHERE pitch = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setDouble(1, pitch.getPitch());
        ResultSet rs = pstmt.executeQuery();
        return null;
    }
}
