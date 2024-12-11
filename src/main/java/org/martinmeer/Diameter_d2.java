package org.martinmeer;

public class Diameter_d2 {

    private final int nominalDiameter;
    private final double pitch;

    public Diameter_d2(int nominalDiameter, double pitch) {
        this.nominalDiameter = nominalDiameter;
        this.pitch = pitch;
    }

    public double d2_generate() {
        return nominalDiameter - (0.6495 * pitch);
    }
}
