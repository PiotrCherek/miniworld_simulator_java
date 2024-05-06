package org.example;

public class Wolf extends Animal {
    private static final char WOLF_CHAR = 'W';
    private static final int WOLF_STRENGTH = 9;
    private static final int WOLF_INITIATIVE = 5;
    public Wolf(World world, int x, int y) {
        super(world, x, y);
        this.setStrength(WOLF_STRENGTH);
        this.setInitiative(WOLF_INITIATIVE);
    }
    @Override
    public char draw() { return WOLF_CHAR; }
}
