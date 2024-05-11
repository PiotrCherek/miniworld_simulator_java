package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class controlButton extends JButton {
    public enum controlButtonType {
        NEXT_TURN,
        SAVE_GAME,
        LOAD_GAME;
    }
    controlButtonType buttonType;
    Human human;
    World world;
    controlButton(controlButtonType buttonType, Human human, World world) {
        super();
        this.buttonType = buttonType;
        this.human = human;
        this.world = world;
        switch (buttonType) {
            case NEXT_TURN -> this.setText("Next Turn");
            case SAVE_GAME -> this.setText("Save Game");
            case LOAD_GAME -> this.setText("Load Game");
        }
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent event) {
                controlButtonAction();
            }
        });
    }
    private void controlButtonAction() {
        switch (buttonType) {
            case NEXT_TURN -> nextTurn();
            case SAVE_GAME -> saveGame();
            case LOAD_GAME -> loadGame();
        }
    }
    private void nextTurn() {
        world.makeTurn(human);
    }
    private void saveGame() {
        world.saveGame(human, human.getSuperpowerActive(), human.getSuperpowerCooldown(), human.getSuperpowerTurnsLeft());
    }
    private void loadGame() {
        world.loadGame();
    }
}
