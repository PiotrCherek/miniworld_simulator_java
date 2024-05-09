package org.example;
import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Frame extends JFrame {
    private static final int frame_width = 1200;
    private static final int frame_height = 700;
    private static final int mainPanel_height = frame_height;
    private static final int mainPanel_width = (int) (frame_width * 0.7);
    World world = null;

    Frame(World world) throws UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(new FlatDarculaLaf());
        this.world = world;
        this.setSize(frame_width, frame_height);
        this.setTitle("MINIWORLD");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public Color getOrganismColor(char organismChar) {
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
    public void showInterface() {
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.gray);
        mainPanel.setLayout(null);
        mainPanel.setBounds(0,0, mainPanel_width, mainPanel_height);

        JPanel boardPanel = new JPanel();
        int boardPanelWidth = 400;
        int boardPanelHeight = 400;
        int boardPanelX = 100;
        int boardPanelY = (int)((frame_height - boardPanelHeight)/2.5);
        boardPanel.setBounds(boardPanelX, boardPanelY, boardPanelWidth, boardPanelHeight);
        boardPanel.setLayout(new GridLayout(Defines.WORLD_M, Defines.WORLD_N));
            //button.setBackground(Color.CYAN);
        for (int row = 0; row < Defines.WORLD_N; row++) {
            for (int col = 0; col < Defines.WORLD_M; col++) {
                //System.out.print(board[row][col] + " ");
//                JButton button = new JButton();
                char organismChar = world.getBoardCell(row, col);
//                button.setBackground(getOrganismColor(organismChar));

                boardField field = new boardField(world, row, col, organismChar);
                boardPanel.add(field);
            }
        }

        JPanel legendPanel = new JPanel();
        int legendPanelWidth = 200;
        int legendPanelHeight = 400;
        int legendPanelX = boardPanelX + boardPanelWidth + 20;
        int legendPanelY = (int)((frame_height - boardPanelHeight)/2.5);
        legendPanel.setBounds(legendPanelX, legendPanelY, legendPanelWidth, legendPanelHeight);
        legendPanel.setLayout(new GridLayout(0, 1));
        for (Defines.organismColors color : Defines.organismColors.values()) {
            //System.out.println(color.getOrganismName() + ": " + color.getColor());
            JButton button = new JButton();
            button.setText(color.getOrganismName());
            button.setBackground(color.getColor());
            //button.setPreferredSize(new Dimension(legendPanelWidth - 5, legendPanelHeight / Defines.NUM_OF_ORGANISMS));
            legendPanel.add(button);
        }

        //mainPanel.add(boardPanel);
        //mainPanel.add(legendPanel);
        //this.add(mainPanel);
        this.add(boardPanel);
        this.add(legendPanel);
        this.setVisible(true);
    }
}
