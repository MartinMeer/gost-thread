package org.martinmeer.imdb;

import lombok.Getter;

@Getter
public class Pitch {
    private final double pitch;

    public Pitch(String pitch) {
        this.pitch = Double.parseDouble(pitch);
    }

}
