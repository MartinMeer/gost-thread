package org.martinmeer.params;

import org.martinmeer.jbdc.GostDAO;
import org.martinmeer.jbdc.PitchDAO;
import org.martinmeer.utils.Namespace;

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
            String query = "SELECT pitch_default FROM "
                    + Namespace.NOMINAL_SIZE.getDbTable()
                    + " WHERE "
                    + Namespace.NOMINAL_SIZE.getDbColumn()
                    + " = ?;";
            GostDAO<String> gostDAO = new PitchDAO();

            Map<Namespace, String> sql = Map.of(
                    Namespace.DB_QUERY, query,
                    Namespace.NOMINAL_SIZE, nominalSize.getNominalSize()
                    );
            return gostDAO.getValue(sql);
        }
        return input;
    }
}