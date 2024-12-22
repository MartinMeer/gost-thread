package org.martinmeer.params;

import lombok.Getter;

import java.io.IOException;
import java.sql.SQLException;

public class Pitch implements ValueGen{

    private final String pitchStr;
    @Getter
    private double pitch;

    public Pitch(String pitchStr) {
        this.pitchStr = pitchStr;
    }

    @Override
    public void generateValue() throws SQLException, IOException {
        //if null
        pitch = Double.parseDouble(pitchStr);
    }
}
