package org.example;
import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.plaf.synth.SynthLookAndFeel;

public class Main {
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        //UIManager.setLookAndFeel(new FlatDarculaLaf());
        World world = new World();
        world.startSimulation();

//        Frame frame = new Frame(world);
//        frame.showInterface();
        //frame.grid();
    }
}

///////////////////////////////////
/*		ORGANISM CHARS

'H': "Human";
'W': "Wolf";
'S': "Sheep";
'F': "Fox";
'T': "Turtle";
'A': "Antelope";
'G': "Grass";
'M': "Sow thistle";
'P': "Guarana";
'J': "Belladonna";
'B': "Sosnowsky hogweed";

*/
///////////////////////////////////