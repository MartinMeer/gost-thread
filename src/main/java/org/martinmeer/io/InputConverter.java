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
        String spacer = "-";
        Map<String, String> splitInput = new HashMap<>();
        splitInput.put("nominalThread", normalized.split(spacer)[0]);
        splitInput.put("pitchHelixPh", normalized.split(spacer)[1].split(spacer)[0]);
        splitInput.put("threadToleranceField", normalized.split(spacer)[1]);
        if (normalized.split(spacer).length > 2) {
            splitInput.put("threadDirection", normalized.split(spacer)[2]);
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
                .replace("н", "h")
                .replace("е", "e");
    }
}
