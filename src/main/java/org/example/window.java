package org.example;
import javax.swing.JFrame;
public class window {

    private JFrame mainWindow;
    public window() {
        mainWindow = new JFrame();
        mainWindow.setTitle("Miniworld Simulator");
        mainWindow.setSize(800, 500);
        mainWindow.setLocationRelativeTo(null);
        mainWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void show() {
        mainWindow.setVisible(true);
    }

}
