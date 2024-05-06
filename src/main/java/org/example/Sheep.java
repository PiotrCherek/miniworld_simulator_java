package org.example;

public class Sheep extends Animal {
    private static final char SHEEP_CHAR = 'S';
    private static final int SHEEP_STRENGTH = 4;
    private static final int SHEEP_INITIATIVE = 4;
    public Sheep(World world, int x, int y) {
        super(world, x, y);
        this.setStrength(SHEEP_STRENGTH);
        this.setInitiative(SHEEP_INITIATIVE);
    }
    @Override
    public char draw() { return SHEEP_CHAR; }
}
