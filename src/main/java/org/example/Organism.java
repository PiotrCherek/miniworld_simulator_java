package org.example;
public class Organism {
    private int strength;
    private int initiative;
    private int x, y;
    private int age = 0;
    private boolean dead = false;
    private World world;

    public Organism(World world, int x, int y) {
        this.world = world;
        this.x = x;
        this.y = y;
        this.strength = 0;
        this.initiative = 0;
    }
    void action(World world) {}
    boolean collision(World world, Organism organism) { return false; }
    char draw() { return ' '; }
    public String getOrganismName() {
        char organismChar = draw();
        return switch (organismChar) {
            case 'H' -> "Human";
            case 'W' -> "Wolf";
            case 'S' -> "Sheep";
            case 'F' -> "Fox";
            case 'T' -> "Turtle";
            case 'A' -> "Antelope";
            case 'G' -> "Grass";
            case 'M' -> "Sow thistle";
            case 'P' -> "Guarana";
            case 'J' -> "Belladonna";
            case 'B' -> "Sosnowsky hogweed";
            default -> "No name";
        };
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }
    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void increaseAge() {
        this.age++;
    }
    public void decreaseAge() {
        this.age--;
    }
    public void organismDied() {
        this.dead = true;
    }
    public int getStrength() {
        return strength;
    }
    public int getInitiative() {
        return initiative;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getAge() {
        return age;
    }
    public boolean isDead() {
        return dead;
    }

}
