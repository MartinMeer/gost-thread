package org.martinmeer;

public class BasicPitchDiam {

    private final int nominalDiameter;
    private final double pitch;

    public BasicPitchDiam(int nominalDiameter, double pitch) {
        this.nominalDiameter = nominalDiameter;
        this.pitch = pitch;
    }

    public double generate() {
        return nominalDiameter - (0.6495 * pitch);
    }
}
