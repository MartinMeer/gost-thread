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
        String pitch = null;
        if (matcher.find()) {
            pitch = matcher.group(1);
            return pitchNormalize(pitch);
        }
        return pitch;
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
        Pattern pattern = Pattern.compile("-((\\d[defgh])+)");
        Matcher matcher = pattern.matcher(normalized);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    private String pitchNormalize(String pitch) {
        return (pitch.length() > 1)
                ? pitch.replaceAll(String.valueOf(pitch.charAt(0)), pitch.charAt(0) + ".")
                : pitch;
    }
/** This method prepare input for mapping.*/
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