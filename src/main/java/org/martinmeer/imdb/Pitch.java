package org.martinmeer.imdb;

import lombok.Getter;

@Getter
public class Pitch {
    private final double pitch;

    public Pitch(String inputPitch) {
        pitch = Double.parseDouble(inputPitch);
    }

}
