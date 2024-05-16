package org.example;
import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
public class World {
    private final int n, m;
    private final char[][] board;
    private final Organism[] organisms;
    private int organismCount;
    private final Report report;
    private final Frame frame;
    public World() throws UnsupportedLookAndFeelException {
        this.n = Defines.WORLD_N;
        this.m = Defines.WORLD_M;
        this.board = new char[Defines.WORLD_N][Defines.WORLD_M];
        this.organisms = new Organism[Defines.MAX_AMOUNT_OF_ORGANISMS];
        this.organismCount = 0;
        this.report = new Report();
        UIManager.setLookAndFeel(new FlatDarculaLaf());
        this.frame = new Frame(this);
    }
    public void organismsClear() {
        for (int i=0; i<Defines.MAX_AMOUNT_OF_ORGANISMS; i++) {
            organisms[i] = null;
        }
    }
    public int getOrganismCount() {
        return this.organismCount;
    }
    public Report getReportPTR() {
        return report;
    }
    public void clearWorldBoard() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = Defines.EMPTY_SPACE_CHAR;
            }
        }
    }
    public boolean worldPositionValid(int x, int y) {
        if (x < 0 || x >= Defines.WORLD_N) {
            return false;
        }
        return y >= 0 && y < Defines.WORLD_M;
    }
    public void updateBoard() {
        clearWorldBoard();
        for (int i = 0; i < getOrganismCount(); i++) {
            int col = organisms[i].getX();
            int row = organisms[i].getY();
            if (worldPositionValid(col, row) && !organisms[i].isDead()) {
                board[row][col] = organisms[i].draw();
            }
        }
    }
    public void organismCountIncrease() {
        if (this.organismCount < Defines.MAX_AMOUNT_OF_ORGANISMS - 1) {
            this.organismCount++;
        }
    }
    public void organismCountDecrease() {
        if (this.organismCount > 0) {
            this.organismCount--;
        }
    }
    public boolean findOpponent(int x, int y) {
        for (int i = 0; i < getOrganismCount(); i++) {
            int tempX = organisms[i].getX();
            int tempY = organisms[i].getY();
            if (tempX == x && tempY == y) {
                return true;
            }
        }
        return false;
    }
    public boolean findOpponent(int x, int y, Organism[] opponent, Organism currentOrganism) {
        for (int i = 0; i < getOrganismCount(); i++) {
            int tempX = organisms[i].getX();
            int tempY = organisms[i].getY();
            if (tempX == x && tempY == y && organisms[i] != currentOrganism) {
                opponent[0] = organisms[i];
                return true;
            }
        }
        return false;
    }
    public int[] getFreeNeighbouringCell(Organism organism) {
        int[][] FreeCells = new int[Defines.NUM_OF_DIRECTIONS][Defines.NUM_OF_COORDINATES];
        int numOfFreeCells = 0;
        int x = organism.getX();
        int y = organism.getY();
        //Organism temp;

        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx == 0 && dy == 0) {
                    continue;
                }
                else if (worldPositionValid(x + dx, y + dy)) {
                    if (!findOpponent(x + dx, y + dy)) {
                        FreeCells[numOfFreeCells][0] = x + dx;
                        FreeCells[numOfFreeCells][1] = y + dy;
                        numOfFreeCells++;
                    }
                }
            }
        }

        int[] coords = new int[Defines.NUM_OF_COORDINATES];
        if (numOfFreeCells == 0) {
            coords[0] = -1;
            coords[1] = -1;
            return coords;
        }
        int index = new Random().nextInt(numOfFreeCells);
        coords[0] = FreeCells[index][0];
        coords[1] = FreeCells[index][1];
        return coords;
    }
    public void addOrganism(Organism newOrganism) {
        report.spawnReport(newOrganism.getOrganismName());
        int index = getOrganismCount() - 1;
        int newOrganismInitiative = newOrganism.getInitiative();
        while (index >= 0) {
            int currentOrganismInitiative = organisms[index].getInitiative();
            if (currentOrganismInitiative >= newOrganismInitiative) {
                break;
            }
            organisms[index + 1] = organisms[index];
            index--;
        }
        organisms[index + 1] = newOrganism;
        organismCountIncrease();
    }
    public void createPlant(char plantChar, int x, int y) {
        if (!worldPositionValid(x, y)) {
            return;
        }
        Organism newPlant = null;
        switch (plantChar) {
            case 'G':
                newPlant = new Grass(this, x, y);
                break;
            case 'M':
                newPlant = new SowThistle(this, x, y);
                break;
            case 'P':
                newPlant = new Guarana(this, x, y);
                break;
            case 'J':
                newPlant = new Belladonna(this, x, y);
                break;
            case 'B':
                newPlant = new SosnowskyHogweed(this, x, y);
                break;
            default:
                break;
        }
        if (newPlant != null) {
            addOrganism(newPlant);
        }
    }
    public void createAnimal(char animalChar, int x, int y) {
        if (!worldPositionValid(x, y)) {
            return;
        }
        Organism newAnimal = null;
        switch (animalChar) {
            case 'W':
                newAnimal = new Wolf(this, x, y);
                break;
            case 'S':
                newAnimal = new Sheep(this, x, y);
                break;
            case 'F':
                newAnimal = new Fox(this, x, y);
                break;
            case 'T':
                newAnimal = new Turtle(this, x, y);
                break;
            case 'A':
                newAnimal = new Antelope(this, x, y);
                break;
            default:
                break;
        }
        if (newAnimal != null) {
            addOrganism(newAnimal);
        }
    }
    public Organism createOrganism(char organismChar, int x, int y) {
        Organism newOrganism = null;
        switch (organismChar) {
            case 'W':
                newOrganism = new Wolf(this, x, y);
                break;
            case 'S':
                newOrganism = new Sheep(this, x, y);
                break;
            case 'F':
                newOrganism = new Fox(this, x, y);
                break;
            case 'T':
                newOrganism = new Turtle(this, x, y);
                break;
            case 'A':
                newOrganism = new Antelope(this, x, y);
                break;
            case 'G':
                newOrganism = new Grass(this, x, y);
                break;
            case 'M':
                newOrganism = new SowThistle(this, x, y);
                break;
            case 'P':
                newOrganism = new Guarana(this, x, y);
                break;
            case 'J':
                newOrganism = new Belladonna(this, x, y);
                break;
            case 'B':
                newOrganism = new SosnowskyHogweed(this, x, y);
                break;
            default:
                break;
        }
        return newOrganism;
    }
    public void drawWorld() {
        frame.showInterface();
    }
    public char getBoardCell(int row, int col) {
        return this.board[row][col];
    }
    public void organismKilled(Organism deadOrganism) {
        boolean organismFound = false;
        for (int i = 0; i < getOrganismCount(); i++) {
            if (organisms[i] == deadOrganism) {
                organismFound = true;
            }
            if (organismFound) {
                organisms[i] = organisms[i + 1];
            }
        }
        organismCountDecrease();
    }
    public void multiplication(Organism attacker, Organism opponent) {
        int[] coords = getFreeNeighbouringCell(opponent);
        if (coords[0] == -1 || coords[1] == -1) {
            coords = getFreeNeighbouringCell(attacker);
            if (coords[0] == -1 || coords[1] == -1) {
                return;
            }
        }
        createAnimal(opponent.draw(), coords[0], coords[1]);
    }
    public void handleCollision(Organism attacker, Organism opponent, int dx, int dy) {
        if (attacker.collision(this, opponent) && opponent.collision(this, attacker)) {
            if (attacker.getStrength() != opponent.getStrength()) {
                if (attacker.getStrength() > opponent.getStrength()) {
                    organismKilled(opponent);
                    report.fightReport(attacker.getOrganismName(), opponent.getOrganismName());
                }
                else {
                    organismKilled(attacker);
                    report.fightReport(opponent.getOrganismName(), attacker.getOrganismName());
                }
            }
            else {
                organismKilled(opponent);
                report.fightReport(attacker.getOrganismName(), opponent.getOrganismName());
            }
        }
        else if (attacker.getX() == opponent.getX() && attacker.getY() == opponent.getY()) {
            attacker.setX(attacker.getX() - dx);
            attacker.setY(attacker.getY() - dy);
            if (attacker.draw() == opponent.draw()) {
                multiplication(attacker, opponent);
            }
        }
    }
    public void getRandomCoords(int[] coords) {
        coords[0] = new Random().nextInt(Defines.WORLD_N);
        coords[1] = new Random().nextInt(Defines.WORLD_M);
    }
    public void saveGame(boolean spActive, int spCooldown, int spTurnsLeft) {
        try (FileWriter gameState = new FileWriter("gameState.txt")) {
            gameState.write(getOrganismCount() + "\n");
            for (int i = 0; i < getOrganismCount(); i++) {
                gameState.write(organisms[i].draw() + " " + organisms[i].getAge() + " " +
                        organisms[i].getInitiative() + " " + organisms[i].getStrength() + " " +
                        organisms[i].getX() + " " + organisms[i].getY());
                if (organisms[i].getOrganismName().equals("Human")) {
                    gameState.write(" " + spActive + " " + spCooldown + " " + spTurnsLeft);
                }
                gameState.write("\n");
            }
        }
        catch (IOException exc) {
            exc.printStackTrace();
        }
    }
    public void loadGame() {
        organismsClear();
        this.organismCount = 0;
        Human human;
        try {
            File gameFile = new File("gameState.txt");
            Scanner gameState = new Scanner(gameFile);
            int numOfOrganisms = gameState.nextInt();
            gameState.nextLine();

            char organismChar;
            int age, initiative, strength, x, y;
            for (int i = 0; i < numOfOrganisms; i++) {
                organismChar = gameState.next().charAt(0);
                age = gameState.nextInt();
                initiative = gameState.nextInt();
                strength = gameState.nextInt();
                x = gameState.nextInt();
                y = gameState.nextInt();
                if (organismChar == Defines.HUMAN_CHAR) {
                    human = new Human(this, x, y, frame);
                    human.setInitiative(initiative);
                    human.setStrength(strength);
                    human.setAge(age);
                    boolean superpowerActive = gameState.nextBoolean();
                    int superpowerCooldown = gameState.nextInt();
                    int superpowerTurnsLeft = gameState.nextInt();
                    human.setSuperpowerActive(superpowerActive);
                    human.setSuperpowerCooldown(superpowerCooldown);
                    human.setSuperpowerTurnsLeft(superpowerTurnsLeft);
                    addOrganism(human);
                    frame.addHuman(human);
                } else {
                    Organism newOrganism = createOrganism(organismChar, x, y);
                    newOrganism.setInitiative(initiative);
                    newOrganism.setStrength(strength);
                    newOrganism.setAge(age);
                    addOrganism(newOrganism);
                }
            }
            gameState.close();
        } catch (FileNotFoundException exc) {
            exc.printStackTrace();
        }
        updateBoard();
        drawWorld();
    }
    public void makeTurn() {
        for (int i = 0; i < getOrganismCount(); i++) {
            if (!organisms[i].isDead()) {
                organisms[i].action(this);
            }
        }
        for (int i = 0; i < getOrganismCount(); i++) {
            if (organisms[i].isDead()) {
                organismKilled(organisms[i]);
            }
        }

        updateBoard();
        drawWorld();
        report.reportOfTheTurn();
    }
    public void startSimulation() {
        clearWorldBoard();
        int[] coords = new int[Defines.NUM_OF_COORDINATES];
        getRandomCoords(coords);
        // Creating human, because there is always just one
        Human human = new Human(this, coords[0], coords[1], frame);
        addOrganism(human);
        frame.addHuman(human);
        frame.addReport(report);

        char[] organismChars = {'W', 'S', 'F', 'T', 'A', 'G', 'M', 'P', 'J', 'B'};
        for (int i = 0; i < Defines.NUM_OF_ORGANISMS; i++) {
            // Adding 2-4 specimen of all other organisms
            int numOfSpecimen = new Random().nextInt(3) + 2;

            for (int j = 0; j < numOfSpecimen; j++) {
                // Putting new organism in a random empty cell
                while (findOpponent(coords[0], coords[1])) {
                    getRandomCoords(coords);
                }
                if (i >= Defines.NUM_OF_ANIMALS) {
                    createPlant(organismChars[i], coords[0], coords[1]);
                } else {
                    createAnimal(organismChars[i], coords[0], coords[1]);
                }
            }

        }

        updateBoard();
        drawWorld();
        report.reportOfTheTurn();
    }
}
