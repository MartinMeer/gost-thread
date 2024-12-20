package org.martinmeer.io;

import org.apache.commons.lang3.StringUtils;
import org.martinmeer.utils.ParamNames;

import java.util.HashMap;
import java.util.Map;


public class InputConverter {

    private final String input;

    public InputConverter(String input) {
        this.input = input;
    }

    private Map<ParamNames, String> spliterator() {
        Map<ParamNames, String> splitInputMap = new HashMap<>();
        String delimiter = "-";
        String normalizedInput = normalize(input);
        if (normalizedInput.substring(normalizedInput.length() - 1).equals("-lh")) {
            splitInput.put(ParamNames.DIRECTION, normalized[4]);
        } else {
            splitInput.put(ParamNames.DIRECTION, null);
        }

        splitInputMap.put(ParamNames.NOMINAL_DIAMETER, normalizedInput.split(delimiter)[0]);
        splitInputMap.put(ParamNames.MULTISTART_TREAD, normalizedInput.split(delimiter)[1]);




        String[] normalized = normalize(input).split(delimiter);
        Map<ParamNames, String> splitInput = new HashMap<>();
        splitInput.put(ParamNames.NOMINAL_DIAMETER, normalized[0]);
        splitInput.put(ParamNames.MULTISTART_TREAD, normalized[1]);
        splitInput.put(ParamNames.PITCH, normalized[2]);
        splitInput.put(ParamNames.TOLERANCE_FIELD, normalized[3]);

        return splitInput;
    }

    private String normalize(String input) {
        return input
                .toLowerCase()
                .replace(" ", "")
                .replace("х", "-")
                .replace("*", "-")
                .replace("м", "m")
                .replaceAll("m\\d", "")
                .replace("р", "p")
                .replaceAll("p\\d", "-")
                .replace("н", "h")
                .replace("е", "e");
    }
}
