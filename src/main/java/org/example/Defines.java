package org.example;
import java.awt.Color;

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
    public static final int SAVE_GAME = 'Q';//113; // letter q
    public static final int LOAD_GAME = 'W';//119; // letter w
    public static final char HUMAN_CHAR = 'H';
    public static final int UP = 0;
    public static final int DOWN = 1;
    public static final int LEFT = 2;
    public static final int RIGHT = 3;
    public static final int LEFT_UP = 4;
    public static final int LEFT_DOWN = 5;
    public static final int RIGHT_UP = 6;
    public static final int RIGHT_DOWN = 7;

    public enum organismColors {
        HUMAN("Human", new Color(255, 0, 0)),
        WOLF("Wolf", new Color(0, 255, 0)),
        SHEEP("Sheep", new Color(0, 0, 255)),
        FOX("Fox", new Color(100, 0, 0)),
        TURTLE("Turtle", new Color(0, 100, 0)),
        ANTELOPE("Antelope", new Color(0, 0, 100)),
        GRASS("Grass", new Color(100, 100, 0)),
        SOW_THISTLE("Sow thistle", new Color(0, 100, 100)),
        GUARANA("Guarana", new Color(200, 255, 100)),
        BELLADONNA("Belladonna", new Color(123, 123, 255)),
        SOSNOWSKY_HOGWEED("Sosnowsky hogweed", new Color(255, 50, 100)),
        DEFAULT("Default", new Color(50, 50, 50));

        private final String organismName;
        private final Color color;
        organismColors(String organismName, Color color) {
            this.organismName = organismName;
            this.color = color;
        }
        public String getOrganismName() {
            return organismName;
        }
        public Color getColor() {
            return color;
        }
    }
}
