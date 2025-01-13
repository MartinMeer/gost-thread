package org.martinmeer.params;

import lombok.Getter;
import org.martinmeer.jbdc.GostDAO;
import org.martinmeer.jbdc.PitchDAO;
import org.martinmeer.utils.ParamNames;

import java.io.IOException;
import java.sql.SQLException;

public class Pitch implements ValueGen{

    private final NominalSize nominalSize;
    private final String input;
    @Getter
    private String pitch;

    public Pitch(NominalSize nominalSize, String input) {
        this.nominalSize = nominalSize;
        this.input = input;
    }

    @Override
    public void generateValue() throws SQLException, IOException {
        if (input.isEmpty()) {
            GostDAO<String> gostDAO = new PitchDAO();
            String sql = "";
            pitch = gostDAO.getValue(sql);
        }
        pitch = input;
    }
}