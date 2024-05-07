package org.example;

public class Guarana extends Plant {
    private static final int GUARANA_STRENGTH = 0;
    private static final int GUARANA_STRENGTH_BOOST = 3;
    private static final char GUARANA_CHAR = 'P';

    public Guarana(World world, int x, int y) {
        super(world, x, y);
        setStrength(GUARANA_STRENGTH);
    }

    @Override
    public boolean collision(World world, Organism organism) {
        organism.setStrength(organism.getStrength() + GUARANA_STRENGTH_BOOST);
        return true;
    }

    @Override
    public char draw() {
        return GUARANA_CHAR;
    }
}
