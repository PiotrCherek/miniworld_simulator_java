package org.example;

public class Defines {
    public static final String AUTHOR = "PIOTR CHEREK";
    public static final String INDEX = "198252";
    public static final int WORLD_N = 10;
    public static final int WORLD_M = 10;
    public static final int NUM_OF_DIRECTIONS = 8;
    public static final int NUM_OF_COORDINATES = 2;
    public static final int MAX_CHARS_NAME = 20;
    public static final int NUM_OF_ORGANISMS = 10;
    public static final int NUM_OF_ANIMALS = 5;
    public static final int NUM_OF_PLANTS = 5;
    public static final int MAX_AMOUNT_OF_ORGANISMS = WORLD_N * WORLD_M;
    public static final char EMPTY_SPACE_CHAR = '+';
    public static final int SAVE_GAME = 113; // letter q
    public static final int LOAD_GAME = 119; // letter w

    public enum Directions {
        UP,
        DOWN,
        LEFT,
        RIGHT,
        LEFT_UP,
        LEFT_DOWN,
        RIGHT_UP,
        RIGHT_DOWN
    }
}
