package org.martinmeer.io;

import lombok.Getter;

import java.util.Map;

@Getter
public class InputMap {
    private Map<String, String> inputMap;
    private String pitch;
    private String deviation;

    public InputMap(String inputEn) {
    }
}
