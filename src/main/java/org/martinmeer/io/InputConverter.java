package org.martinmeer.io;

import lombok.Getter;
import org.martinmeer.utils.ParamNames;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

@Getter
public class InputConverter {

    private final String input;
    private final String normalized;

    public InputConverter(String input) {
        this.input = input;
        normalized = normalize(input);
    }

    public Map<ParamNames, String> generateInputMap() {
        Map<ParamNames, String> inputMap = new HashMap<>();
        String[] splitInput = normalized.split("-");
        inputMap.put(ParamNames.DIRECTION, threadDirection(normalized));
        inputMap.put(ParamNames.NOMINAL_DIAMETER, nominalDiameter(splitInput));
        inputMap.put(ParamNames.MULTISTART_TREAD, multistartThread(splitInput));
        inputMap.put(ParamNames.PITCH, );
        inputMap.put(ParamNames.TOLERANCE_FIELD, );
        return inputMap;
    }

    private String nominalDiameter(String[] splitInput) {
        String str = splitInput[0];
        return str.substring(str.length() - 2, str.length() - 1);
    }
    private String multistartThread(String[] splitInput) {
        if (splitInput.length > 1) {
            String str = splitInput[1];
            if (str.startsWith("ph")) {
                return "многозаходная резьба";
            }
        }
        return null;
    }
    private String pitch(String[] splitInput) {
        if (splitInput.length > 1) {
            String str = splitInput[1];
            String pattern = "\\d";
            if (Pattern.matches(pattern, str)) {
                return str;
            }
        }
        if (splitInput.length == )
        return null;
    }

    private String threadDirection(String normalized) {
        return (this.normalized.substring(this.normalized.length() - 1).equals("-lh"))
                ? "левая резьба" : null;
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
