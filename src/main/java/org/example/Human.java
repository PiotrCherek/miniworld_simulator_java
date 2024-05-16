package org.example;
public class Human extends Animal { // HUMAN SUPERPOWER IS PURIFICATION
    private static final int HUMAN_STRENGTH = 5;
    private static final int HUMAN_INITIATIVE = 4;
    private static final int SUPERPOWER_COOLDOWN = 5;
    private static final char HUMAN_CHAR = 'H';
    private boolean superpowerActive = false;
    private int superpowerCooldown = 0;
    private int superpowerTurnsLeft = 0;
    World world;
    Frame frame;

    public Human(World world, int x, int y, Frame frame) {
        super(world, x, y);
        this.world = world;
        this.frame = frame;
        this.setStrength(HUMAN_STRENGTH);
        this.setInitiative(HUMAN_INITIATIVE);
    }
    public void setSuperpowerActive(boolean active) {
        this.superpowerActive = active;
    }
    public void setSuperpowerCooldown(int cooldown) {
        this.superpowerCooldown = cooldown;
    }
    public void setSuperpowerTurnsLeft(int turnsLeft) {
        this.superpowerTurnsLeft = turnsLeft;
    }
    public boolean getSuperpowerActive() {
        return this.superpowerActive;
    }
    public int getSuperpowerCooldown() {
        return this.superpowerCooldown;
    }
    public int getSuperpowerTurnsLeft() {
        return this.superpowerTurnsLeft;
    }
    public void purification(World world) {
        int x = this.getX();
        int y = this.getY();
        Organism[] opponent = new Organism[1];
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx == 0 && dy == 0) continue;
                if (world.worldPositionValid(x + dx, y + dy)) {
                    if (world.findOpponent(x + dx, y + dy, opponent, this)) {
                        //opponent = world.getOrganism(x + dx, y + dy);
                        world.organismKilled(opponent[0]);
                        world.getReportPTR().fightReport(this.getOrganismName(), opponent[0].getOrganismName());
                    }
                }
            }
        }
    }
    @Override
    public void action(World world) {
        world.updateBoard();
        world.drawWorld();
        System.out.println("HUMAN'S MOVE:\n'WSAD' TO MOVE : 'P' FOR SPECIAL ABILITY");
        System.out.println("SUPERPOWER: " + "COOLDOWN - " + this.getSuperpowerCooldown() + " ACTIVE TURNS LEFT - " + this.getSuperpowerTurnsLeft());
        System.out.println("HUMAN STRENGHT: " + this.getStrength());
        this.increaseAge();
        char input = frame.getLastPressedKey();
        int tempX = getX();
        int tempY = getY();
        boolean[] directionChanged = new boolean[1];

        switch (input) {
            case 'w':
                move(world, this, tempX, tempY, 0, -1, directionChanged);
                break;
            case 's':
                move(world, this, tempX, tempY, 0, 1, directionChanged);
                break;
            case 'a':
                move(world, this, tempX, tempY, -1, 0, directionChanged);
                break;
            case 'd':
                move(world, this, tempX, tempY, 1, 0, directionChanged);
                break;
            case 'p':
                if (getSuperpowerCooldown() == 0) {
                    setSuperpowerActive(true);
                    setSuperpowerTurnsLeft(SUPERPOWER_COOLDOWN);
                }
                break;
        }
        if (getSuperpowerActive()) {
            purification(world);
            setSuperpowerTurnsLeft(getSuperpowerTurnsLeft() - 1);
            if (getSuperpowerTurnsLeft() == 0) {
                setSuperpowerCooldown(SUPERPOWER_COOLDOWN);
                setSuperpowerActive(false);
            }
        }
        else {
            if (getSuperpowerCooldown() != 0) {
                setSuperpowerCooldown(getSuperpowerCooldown() - 1);
            }
        }
    }
    @Override
    public char draw() {
        return HUMAN_CHAR;
    }
}
