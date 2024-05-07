package org.example;

public class Belladonna extends Plant {
    private static final int BELLADONNA_STRENGTH = 99;
    private static final char BELLADONNA_CHAR = 'J';

    public Belladonna(World world, int x, int y) {
        super(world, x, y);
        setStrength(BELLADONNA_STRENGTH);
    }

    @Override
    public boolean collision(World world, Organism organism) {
        organism.organismDied();
        return true;
    }

    @Override
    public char draw() {
        return BELLADONNA_CHAR;
    }
}
