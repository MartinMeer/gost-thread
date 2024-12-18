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
        String spacerX = "x";
        String spacerDash = "-";
        Map<String, String> splitInput = new HashMap<>();
        splitInput.put("nominalThread", normalized.split(spacerX)[0]);
        splitInput.put("pitchHelixPh", normalized.split(spacerX)[1].split(spacerDash)[0]);
        splitInput.put("threadToleranceField", normalized.split(spacerDash)[1]);
        if (normalized.split(spacerDash).length > 2) {
            splitInput.put("threadDirection", normalized.split(spacerDash)[2]);
        } else {
            splitInput.put("threadDirection", null);
        }
        return splitInput;
    }

    private String normalize(String input) {
        String copyOf = input;
        String asterisk = Character.toString('\u002a');
        CharSequence[] cs = {
                String.valueOf('\u2010'),
                String.valueOf('\u2012'),
                String.valueOf('\u2013'),
                String.valueOf('\u2014'),
                String.valueOf('\u2015'),
                String.valueOf('\u2212'),
                String.valueOf('\u002d')
        };
        for (int i = 0; i < cs.length; i++) {
            if (copyOf.contains(cs[i])) {
                copyOf.replaceAll((String) cs[i], "-");
                i++;
            }
        }
        return copyOf
                .toLowerCase()
                .replaceAll(" ", "")
                .replaceAll("х", "x")
                .replaceAll(asterisk, "x")
                .replaceAll("м", "m")
                .replaceAll("р", "p")
                .replaceAll("н", "h")
                .replaceAll("е", "e");
    }



}
