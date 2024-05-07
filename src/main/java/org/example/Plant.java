package org.example;
import java.util.Random;
public abstract class Plant extends Organism {
    private static final int PLANT_PROBABILITY_TO_SOW = 10;
    private static final int PLANTS_INITIATIVE = 0;
    public Plant(World world, int x, int y) {
        super(world, x, y);
        this.setInitiative(PLANTS_INITIATIVE);
    }
    @Override
    public void action(World world) {
        increaseAge();
        if (new Random().nextInt(PLANT_PROBABILITY_TO_SOW) == 0) {
            int[] coords = world.getFreeNeighbouringCell(this);
            if (coords[0] == -1 || coords[1] == -1) {
                return;
            }
            world.createPlant(draw(), coords[0], coords[1]);
        }
    }

    @Override
    public boolean collision(World world, Organism organism) {
        return true;
    }

    public abstract char draw();
}
