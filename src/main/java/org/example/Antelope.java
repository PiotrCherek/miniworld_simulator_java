package org.example;
import java.util.Random;
public class Antelope extends Animal {
    private static final char ANTELOPE_CHAR = 'A';
    private static final int ANTELOPE_STRENGTH = 4;
    private static final int ANTELOPE_INITIATIVE = 4;
    private static final int ANTELOPE_RANGE_OF_MOVEMENT = 2;
    private static final int ANTELOPE_CHANCE_TO_ESCAPE = 2;
    public Antelope(World world, int x, int y) {
        super(world, x, y);
        this.setStrength(ANTELOPE_STRENGTH);
        this.setInitiative(ANTELOPE_INITIATIVE);
    }
    @Override
    public void action(World world) {
        for (int i = 0; i < ANTELOPE_RANGE_OF_MOVEMENT; i++) {
            super.action(world);
        }
        decreaseAge();
    }
    @Override
    public boolean collision(World world, Organism organism) {
        if (draw() == organism.draw()) {
            return false;
        }
        else if (new Random().nextInt(ANTELOPE_CHANCE_TO_ESCAPE) == 0) {
            Report report = world.getReportPTR();
            report.addReport("Antelope has run away from " + organism.getOrganismName());
            moveToFreeCell(world, this);
            return false;
        }
        return true;
    }
    @Override
    public char draw() { return ANTELOPE_CHAR; }
}
