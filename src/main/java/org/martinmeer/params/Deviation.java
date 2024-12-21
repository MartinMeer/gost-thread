package org.martinmeer.params;

import org.martinmeer.utils.ParamNames;

import java.util.Map;


public class Deviation implements ValueGen, LookInDB {

    private final String toleranceZone;
    private int d2;
    private int d;

    public int get_d2() {
        return d2;
    }

    public int get_d() {
        return d;
    }

    public Deviation(String toleranceZone) {
        this.toleranceZone = toleranceZone;
    }


    @Override
    public void sendQuery(String data) {

    }

    @Override
    public void generateValue(String toleranceZone) {
        Map<ParamNames, String> parsed = parse(toleranceZone);
    }

    private Map<ParamNames, String> parse (String toleranceZone) {
        String d2 = toleranceZone.substring (1, 2);
        String d = d2;
        if (toleranceZone.length() == 4) {
            d = toleranceZone.substring(4);
        }
        return Map.of(
                ParamNames.PITCH_DIAM_TOLERANCE, d2,
                ParamNames.MAJOR_DIAM_TOLERANCE, d
        );
    }
}
