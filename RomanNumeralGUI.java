// these packages must be imported to be able to extend the JFrame class to the RomanNumeralGUI class and to use the GridLayout class
import javax.swing.*;
import java.awt.*;

// this class contains a constructor that gets information passed in to it, so the JFrame can be initialized
public class RomanNumeralGUI extends JFrame {
    
    // this constructor is called when a new object is instantiated and using the arguments passed-in, initializes the Roman-Arabic Numerals Conversion GUI
    public RomanNumeralGUI(String title, int height, int width, int horizDistance, int vertDistance) {
        
        setTitle(title);
        setSize(height, width);
        setLocation(horizDistance, vertDistance);
        setLayout(new GridLayout(1, 2));
        setDefaultCloseOperation(RomanNumeralGUI.EXIT_ON_CLOSE);
        setVisible(true);
        
    } // constructor RomanNumeralGUI
    
} // class RomanNumeralGUI
