package org.martinmeer.params;

import lombok.Getter;
import org.martinmeer.jbdc.GostDAO;
import org.martinmeer.jbdc.PitchDAO;
import org.martinmeer.utils.ParamNames;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

public class Pitch {

    private final NominalSize nominalSize;
    private final String input;
    /*@Getter
    private String pitch;*/

    public Pitch(NominalSize nominalSize, String input) {
        this.nominalSize = nominalSize;
        this.input = input;
    }

    public String getValue() throws SQLException, IOException {
        if (input == null) {
            GostDAO<String> gostDAO = new PitchDAO();
            Map<ParamNames, String> sql = Map.of(
                    ParamNames.DB_QUERY,"SELECT pitch_default FROM nom_diams WHERE nom_diam = ?;",
                    ParamNames.NOMINAL_SIZE, nominalSize.getNominalSize(),
                    ParamNames.DB_ALIAS, "pitch_default"
                    );
            return gostDAO.getValue(sql);
        }
        return input;
    }
}