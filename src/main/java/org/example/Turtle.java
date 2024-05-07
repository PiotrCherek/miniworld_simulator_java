package org.example;
import java.util.Random;
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
    public void action(World world) {
        Random rand = new Random();
        if (rand.nextInt(TURTLE_CHANCE_TO_MOVE) == 0) {
            super.action(world);
        } else {
            increaseAge();
        }
    }
    @Override
    public boolean collision(World world, Organism organism) {
        if (organism.draw() == this.draw()) {
            return true;
        }
        if (organism.getInitiative() < this.getInitiative()) {
            return true;
        }
        if (organism.getStrength() < MAX_STRENGTH_TO_REFLECT) {
            Report report = world.getReportPTR();
            report.addReport("Turtle has deflected attack from " + organism.getOrganismName());
            return false;
        }
        return true;
    }
    @Override
    public char draw() { return TURTLE_CHAR; }
}
