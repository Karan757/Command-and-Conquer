package main;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.JFrame;



public class GUI {

    private JFrame frame;
    private GameEngine gameArea;

    public GUI() throws IOException {
        frame = new JFrame("RunTime Terror!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        gameArea = new GameEngine();
        gameArea.setLayout(null);
        frame.getContentPane().add(gameArea);
        
        
        
       
        
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setUndecorated(true);
        frame.setPreferredSize(new Dimension(2991, 1680));
        frame.setResizable(false);
        frame.setSize(2600, 1500);
        frame.pack();
        frame.setVisible(true);
        //frame.setLocation(-100,0);
       
    }
    
}