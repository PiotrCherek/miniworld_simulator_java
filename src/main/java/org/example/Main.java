package org.example;
import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        World world = new World();
        //world.startSimulation();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                window main = new window();
                main.show();
            }
        });


    }
}