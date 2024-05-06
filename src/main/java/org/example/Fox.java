package org.example;

public class Fox extends Animal {
    private static final char FOX_CHAR = 'F';
    private static final int FOX_STRENGTH = 3;
    private static final int FOX_INITIATIVE = 7;
    public Fox(World world, int x, int y) {
        super(world, x, y);
        this.setStrength(FOX_STRENGTH);
        this.setInitiative(FOX_INITIATIVE);
    }
    @Override
    public void move(World world, Animal animal, int x, int y, int dx, int dy, boolean[] directionChanged) {
        if (world.worldPositionValid(x + dx, y + dy)) {
            Organism[] opponent = new Organism[1];
            if (world.findOpponent(x + dx, y + dy, opponent, animal)) {
                if (opponent[0].getStrength() > animal.getStrength()) {
                    return;
                }
                animal.changeX(dx);
                animal.changeY(dy);
                world.handleCollision(animal, opponent[0], dx, dy);
            }
            else {
                animal.changeX(dx);
                animal.changeY(dy);
            }
            directionChanged[0] = true;
        }
    }
    @Override
    public char draw() { return FOX_CHAR; }
}
