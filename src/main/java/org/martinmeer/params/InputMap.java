package org.martinmeer.params;

import org.martinmeer.utils.ParamNames;

import java.util.Map;

public class InputMap {

    private final Map<ParamNames, String> inputMap;

    public InputMap(Map<ParamNames, String> inputMap) {
        this.inputMap = inputMap;
    }

    public String getParameter(ParamNames paramName) {
        return inputMap.get(paramName);
    }
}
