package org.martinmeer.io;

import lombok.Getter;
import org.martinmeer.utils.ParamNames;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
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

        inputMap.put(ParamNames.DIRECTION, threadDirection(normalized));
        inputMap.put(ParamNames.NOMINAL_DIAMETER, nominalDiameter(normalized));
        inputMap.put(ParamNames.MULTISTART_TREAD, multistartThread(normalized));
        inputMap.put(ParamNames.PITCH, pitch(normalized));
        inputMap.put(ParamNames.TOLERANCE_FIELD, toleranceField(normalized) );
        return inputMap;
    }

    private String nominalDiameter(String normalized) {
        String[] splitInput = normalized.split("-");
        String str = splitInput[0];
        return str.substring(1);
    }
    private String multistartThread(String normalized) {
        Pattern pattern = Pattern.compile("ph\\d");
        Matcher matcher = pattern.matcher(normalized);
        if (matcher.find()) {
            return "многозаходная резьба";
        }
        return null;
    }

    private String pitch(String normalized) {
        Pattern pattern = Pattern.compile("-(\\d+)-");
        Matcher matcher = pattern.matcher(normalized);
        if (matcher.find()) {
            String rawPitch = matcher.group(1);
            String pitch = rawPitch.charAt(0)
                    + "."
                    + rawPitch.substring(1);
            return pitch.replaceAll()
        }
        return null;
    }

    private String threadDirection(String normalized) {
        Pattern pattern = Pattern.compile("-lh");
        Matcher matcher = pattern.matcher(normalized);
        if (matcher.find()) {
            return "левая резьба";
        }
        return null;
    }
    private String toleranceField(String normalized) {
        Pattern pattern = Pattern.compile("\\d[defgh]\\d[defgh]");
        Matcher matcher = pattern.matcher(normalized);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    private String normalize(String input) {
        String normalized = input
                .toLowerCase()
                .replace(" ", "")
                .replace(".", "")
                .replace(",", "")
                .replace("х", "-")
                .replace("x", "-")
                .replace("*", "-")
                .replace("м", "m")
                .replace("р", "p")
                .replaceAll("p(\\d)", "-$1")
                .replace("н", "h")
                .replace("е", "e");
        return normalized;
    }
}