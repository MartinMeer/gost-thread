package org.martinmeer.params;

import lombok.Getter;
import org.martinmeer.jbdc.DeviationDAO;
import org.martinmeer.utils.ParamNames;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;


public class Deviation implements ValueGen, LookInDB<Integer> {

    private final String toleranceZone;
    @Getter
    private int pitchDiamDeviance;
    @Getter
    private int majorDiamDeviance;
    @Getter
    private final Pitch pitch;

    public Deviation(String toleranceZone, Pitch pitch) {
        this.toleranceZone = toleranceZone;
        this.pitch = pitch;
    }


    @Override
    public Integer sendQuery(String data) throws SQLException, IOException {
        DeviationDAO deviationDAO = new DeviationDAO(data, pitch.getPitch());
        return deviationDAO.getValue();
    }

    @Override
    public void generateValue() throws SQLException, IOException {
        Map<ParamNames, String> parsed = parse(toleranceZone);
        pitchDiamDeviance = sendQuery(parsed.get(ParamNames.PITCH_DIAM_TOLERANCE));
        majorDiamDeviance = sendQuery(parsed.get(ParamNames.MAJOR_DIAM_TOLERANCE));
    }

    private Map<ParamNames, String> parse (String toleranceZone) {
        String d2 = toleranceZone.substring (1, 2);
        String d;
        if (toleranceZone.length() > 3) {
            d = toleranceZone.substring(3);
        } else {
            d = toleranceZone.substring (1, 2);
        }
        return Map.of(
                ParamNames.PITCH_DIAM_TOLERANCE, d2,
                ParamNames.MAJOR_DIAM_TOLERANCE, d
        );
    }
}
