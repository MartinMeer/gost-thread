package org.martinmeer.io;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;


public class InputConverter {

    private final String input;

    public InputConverter(String input) {
        this.input = input;
    }

    private Map<String, String> spliterator() {
        var normalized = normalize(input);
        String delimiter = "-";
        Map<String, String> splitInput = new HashMap<>();
        splitInput.put("nominalThread", normalized.split(delimiter)[0]);
        splitInput.put("pitchHelixAndPitch", normalized.split(delimiter)[1]);
        splitInput.put("threadToleranceField", normalized.split(delimiter)[2]);
        if (normalized.endsWith("-lh")) {
            splitInput.put("threadDirection", normalized.substring(normalized.length() - 1, normalized.length() - 4));
        } else {
            splitInput.put("threadDirection", null);
        }
        return splitInput;
    }

    private String normalize(String input) {
        return input
                .toLowerCase()
                .replace(" ", "")
                .replace("х", "-")
                .replace("*", "-")
                .replace("м", "m")
                .replace("р", "p")
                .replaceAll("p\\d", "-")
                .replace("н", "h")
                .replace("е", "e");
    }
}
