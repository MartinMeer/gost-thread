package org.martinmeer.params;

import org.martinmeer.utils.Namespace;

import java.util.Map;

public class ParamMap {

    private final Map<Namespace, String> inputMap;

    public ParamMap(Map<Namespace, String> inputMap) {
        this.inputMap = inputMap;
    }

    public String getParameter(Namespace paramName) {
        return inputMap.get(paramName);
    }
}
