package org.example;
import java.util.Scanner;
public class Human extends Animal { // HUMAN SUPERPOWER IS PURIFICATION
    private static final int HUMAN_STRENGTH = 5;
    private static final int HUMAN_INITIATIVE = 4;
    private static final int SUPERPOWER_COOLDOWN = 5;
    private boolean superpowerActive = false;
    private int superpowerCooldown = 0;
    private int superpowerTurnsLeft = 0;

    public Human(World world, int x, int y) {
        super(world, x, y);
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
}
