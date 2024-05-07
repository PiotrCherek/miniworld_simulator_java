package org.example;
public class Grass extends Plant {
    private static final int GRASS_STRENGTH = 0;
    private static final char GRASS_CHAR = 'G';
    public Grass(World world, int x, int y) {
        super(world, x, y);
        setStrength(GRASS_STRENGTH);
    }

    @Override
    public char draw() {
        return GRASS_CHAR;
    }
}
