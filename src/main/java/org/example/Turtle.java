package org.example;

public class Turtle extends Animal {
    private static final char TURTLE_CHAR = 'T';
    private static final int TURTLE_STRENGTH = 2;
    private static final int TURTLE_INITIATIVE = 1;
    private static final int MAX_STRENGTH_TO_REFLECT = 5;
    private static final int TURTLE_CHANCE_TO_MOVE = 4;
    public Turtle(World world, int x, int y) {
        super(world, x, y);
        this.setStrength(TURTLE_STRENGTH);
        this.setInitiative(TURTLE_INITIATIVE);
    }
    @Override
    public char draw() { return TURTLE_CHAR; }
}
