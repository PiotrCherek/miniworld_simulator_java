package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Frame extends JFrame {
    private static final int frame_width = 1200;
    private static final int frame_height = 700;
    private static final int board_width = frame_height;
    private static final int board_height = (int) (frame_width * 0.6);

    Frame() {
        this.setSize(frame_width, frame_height);
        this.setTitle("MINIWORLD");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
//        this.add(new JButton("X"));
//        this.add(new JButton("X"));
//        this.add(new JButton("X"));
//        this.add(new JButton("X"));
//        this.add(new JButton("X"));
//        this.add(new JButton("X"));
//        this.add(new JButton("X"));
//        this.add(new JButton("X"));
//        this.add(new JButton("X"));

        this.setVisible(true);


    }

    public void showInterface() {
        JPanel boardPanel = new JPanel();
        boardPanel.setBounds(0,0, board_width, board_height - 100);
        boardPanel.setBackground(Color.blue);
        boardPanel.setLayout(new GridLayout(3,3));
        //boardPanel.setLayout(null);
//        JButton button = new JButton("Click Me");
//        boardPanel.add(button);
        for (int i = 0; i < 9/*(Defines.WORLD_M * Defines.WORLD_N)*/; i++) {
            JButton button = new JButton("Click Me");
            boardPanel.add(button);
            //boardPanel.add(new JButton("X"));
        }

        this.add(boardPanel);
        this.setVisible(true);
    }
    public void grid() {
        this.add(new JButton("X"));
        this.add(new JButton("X"));
        this.add(new JButton("X"));
        this.add(new JButton("X"));
        this.add(new JButton("X"));
        this.add(new JButton("X"));
        this.add(new JButton("X"));
        this.add(new JButton("X"));
        this.add(new JButton("X"));

        this.setVisible(true);
    }
}


//package org.example;
//import javax.swing.*;
//import java.awt.*;
//
//public class Frame extends JFrame {
//    private static final int frame_width = 1200;
//    private static final int frame_height = 700;
//    private static final int board_width = frame_height;
//    private static final int board_height = (int) (frame_width * 0.6);
//
//    Frame() {
//        this.setSize(frame_width, frame_height);
//        this.setTitle("MINIWORLD");
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setResizable(false);
//        this.setLayout(null); // Use BorderLayout for main layout
//        this.setLocationRelativeTo(null);
//        this.setVisible(true);
//    }
//
//    public void showInterface() {
//        JPanel boardPanel = new JPanel();
//        boardPanel.setBounds(0,0,200,200);
//        boardPanel.setLayout(new GridLayout(3, 3)); // Set GridLayout with 3 rows and 3 columns
//        boardPanel.setBackground(Color.blue);
//
//        JButton button = new JButton("Button ");
//        boardPanel.add(button);
////        for (int i = 0; i < 9; i++) {
////            JButton button = new JButton("Button " + (i + 1));
////            boardPanel.add(button);
////        }
//
//        this.add(boardPanel); // Add the panel to the center of the frame
//    }
//}
