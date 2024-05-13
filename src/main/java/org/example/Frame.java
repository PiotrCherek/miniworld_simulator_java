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
    Human human;
    World world;

    Frame(World world) {
        this.world = world;
        this.setSize(frame_width, frame_height);
        this.setTitle("MINIWORLD");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public void addHuman(Human human) {
        this.human = human;
    }
    public void showInterface() {
        Container pane = this.getContentPane();
        pane.removeAll();

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
        for (int row = 0; row < Defines.WORLD_N; row++) {
            for (int col = 0; col < Defines.WORLD_M; col++) {
                char organismChar = world.getBoardCell(row, col);
                boardField field = new boardField(world, row, col, organismChar);
                boardPanel.add(field);
            }
        }
        this.add(boardPanel);

        JPanel legendPanel = new JPanel();
        int legendPanelWidth = 200;
        int legendPanelHeight = 400;
        int legendPanelX = boardPanelX + boardPanelWidth + 20;
        int legendPanelY = (int)((frame_height - boardPanelHeight)/2.5);
        legendPanel.setBounds(legendPanelX, legendPanelY, legendPanelWidth, legendPanelHeight);
        legendPanel.setLayout(new GridLayout(0, 1));
        for (Defines.organismColors color : Defines.organismColors.values()) {
            JButton button = new JButton();
            button.setText(color.getOrganismName());
            button.setBackground(color.getColor());
            legendPanel.add(button);
        }
        this.add(legendPanel);

        JPanel controlPanel = new JPanel();
        int controlPanelWidth = legendPanelWidth * 2;
        int controlPanelHeight = legendPanelHeight/4;//(int)(legendPanelHeight * 1.35);
        int controlPanelX = legendPanelX + legendPanelWidth + 20;
        int controlPanelY = boardPanelY/2;
        controlPanel.setBounds(controlPanelX, controlPanelY, controlPanelWidth, controlPanelHeight);
        controlPanel.setLayout(new GridLayout(1, 1));
        controlButton nextTurnButton = new controlButton(controlButton.controlButtonType.NEXT_TURN, human, world);
        controlButton saveGameButton = new controlButton(controlButton.controlButtonType.SAVE_GAME, human, world);
        controlButton loadGameButton = new controlButton(controlButton.controlButtonType.LOAD_GAME, human, world);
        controlPanel.add(nextTurnButton);
        controlPanel.add(saveGameButton);
        controlPanel.add(loadGameButton);
        this.add(controlPanel);

        this.setVisible(true);
    }
}
