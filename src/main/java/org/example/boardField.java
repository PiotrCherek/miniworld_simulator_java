package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class boardField extends JButton {
    private final int row;
    private final int col;
    World world;
    boardField(World world, int row, int col, char organismChar) {
        super();
        this.row = row;
        this.col = col;
        this.world = world;
        this.setBackground(getOrganismColor(organismChar));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent event) {
                organismMenu();
            }
        });
    }

    private void organismMenu() {
        JPopupMenu organismMenu = new JPopupMenu();
        for (Defines.organismColors organisms : Defines.organismColors.values()) {
            if (Objects.equals(organisms.getOrganismName(), "Human") || Objects.equals(organisms.getOrganismName(), "Default")) { continue; }
            JMenuItem organism = new JMenuItem(organisms.getOrganismName());
            organism.addActionListener(event -> {
                freeSpace();
                world.addOrganism(world.createOrganism(getOrganismChar(organisms.getOrganismName()), this.col, this.row));
                world.updateBoard();
                world.drawWorld();
            });
            organismMenu.add(organism);
        }
        organismMenu.show(this, 0, 0);
    }
    private Color getOrganismColor(char organismChar) {
        //Organism temp = new Organism(this.world);
        return switch (organismChar) {
            case 'H' -> Defines.organismColors.HUMAN.getColor();//new Color(255,0,0);//"Human";
            case 'W' -> Defines.organismColors.WOLF.getColor();//new Color(0,255,0);
            case 'S' -> Defines.organismColors.SHEEP.getColor();//new Color(0,0,255);
            case 'F' -> Defines.organismColors.FOX.getColor();//new Color(100,0,0);
            case 'T' -> Defines.organismColors.TURTLE.getColor();//new Color(0,100,0);
            case 'A' -> Defines.organismColors.ANTELOPE.getColor();//new Color(0,0,100);
            case 'G' -> Defines.organismColors.GRASS.getColor();//new Color(100,100,0);
            case 'M' -> Defines.organismColors.SOW_THISTLE.getColor();//new Color(0,100,100);
            case 'P' -> Defines.organismColors.GUARANA.getColor();//new Color(200,255,100);
            case 'J' -> Defines.organismColors.BELLADONNA.getColor();//new Color(123,123,255);
            case 'B' -> Defines.organismColors.SOSNOWSKY_HOGWEED.getColor();//new Color(255,50,100);
            default -> Defines.organismColors.DEFAULT.getColor();//new Color(255,255,255);
        };
    }
    private char getOrganismChar(String organismName) {
        return switch (organismName) {
            case "Human" -> 'H';
            case "Wolf" -> 'W';
            case "Sheep" -> 'S';
            case "Fox" -> 'F';
            case "Turtle" -> 'T';
            case "Antelope" -> 'A';
            case "Grass" -> 'G';
            case "Sow thistle" -> 'M';
            case "Guarana" -> 'P';
            case "Belladonna" -> 'J';
            case "Sosnowsky hogweed" -> 'B';
            default -> throw new IllegalStateException("Unexpected value: " + organismName);
        };
    }
    private void freeSpace() {
        Organism[] opponent = new Organism[1];
        if (world.findOpponent(this.col, this.row, opponent, null)) {
            world.organismKilled(opponent[0]);
        }
    }
}
