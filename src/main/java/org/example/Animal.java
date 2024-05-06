package org.example;

public abstract class Animal extends Organism {
    public Animal(World world, int x, int y) {
        super(world, x, y);
    }
    public void changeX(int dx) {
        this.setX(this.getX() + dx);
    }
    public void changeY(int dy) {
        this.setY(this.getY() + dy);
    }
    public void move(World world, Animal animal, int x, int y, int dx, int dy, boolean[] directionChanged) {
        if (world.worldPositionValid(x + dx, y + dy)) {
            animal.changeX(dx);
            animal.changeY(dy);
            Organism opponent = null;
            if (world.findOpponent(x + dx, y + dy)) {
                world.handleCollision(animal, opponent, dx, dy);
            }
            directionChanged[0] = true;
        }
    }
    public void moveToFreeCell(World world, Animal animal) {
        int x = animal.getX();
        int y = animal.getY();
        boolean moved = false;
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (!world.findOpponent(x + dx, y + dy)) {
                    move(world, animal, x, y, dx, dy, new boolean[]{moved});
                    if (moved) {
                        return;
                    }
                }
            }
        }
    }

    @Override
    public void action(World world) {
        this.increaseAge();
        boolean[] directionChanged = new boolean[]{false};
        int tempX = getX();
        int tempY = getY();

        while (!directionChanged[0]) {
            int randomDirection = (int) (Math.random() * Defines.NUM_OF_DIRECTIONS);
            switch (randomDirection) {
                case Defines.UP:
                    move(world, this, tempX, tempY, 0, -1, directionChanged);
                    break;
                case Defines.DOWN:
                    move(world, this, tempX, tempY, 0, 1, directionChanged);
                    break;
                case Defines.LEFT:
                    move(world, this, tempX, tempY, -1, 0, directionChanged);
                    break;
                case Defines.RIGHT:
                    move(world, this, tempX, tempY, 1, 0, directionChanged);
                    break;
                case Defines.LEFT_UP:
                    move(world, this, tempX, tempY, -1, -1, directionChanged);
                    break;
                case Defines.RIGHT_UP:
                    move(world, this, tempX, tempY, 1, -1, directionChanged);
                    break;
                case Defines.LEFT_DOWN:
                    move(world, this, tempX, tempY, -1, 1, directionChanged);
                    break;
                case Defines.RIGHT_DOWN:
                    move(world, this, tempX, tempY, 1, 1, directionChanged);
                    break;
                default:
                    break;
            }
        }
    }
    @Override
    public boolean collision(World world, Organism organism) {
        return organism.draw() != this.draw(); // multiplication
    }
}
