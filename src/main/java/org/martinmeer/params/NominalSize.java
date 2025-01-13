package org.martinmeer.params;

import lombok.Getter;

public class NominalSize {

    @Getter
    private String nominalSize;

    public NominalSize(String input) {
        nominalSize = input;
    }
}
