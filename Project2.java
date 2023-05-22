/**
* Project #2 converts Roman Numerals from a text file to Arabic Numerals and places the Arabic Numeral values inside of unsorted and sorted Linked Lists and displays the results in a GUI
* Lab Section: CSCI 212 11A
* @author  Huzayfah Hayyan Awan
* @version 1.0
* @since   2023-03-19
*/

/* these must be imported to access the StringTokenizer class and Container and TextArea classes */
import java.util.*;
import java.awt.*;

public class Project2 {
    
    // creates an object from the TextFileInput class which stores the file of Roman Numerals input.txt
    private static TextFileInput numeralsFile;
    
    // creates a GUI object using the RomanNumeralGUI class which extends the JFrame class
    private static RomanNumeralGUI numeralsRomanArabicGUI;
    private static Container numeralsContentPane;
    private static TextArea romanNumeralsColumn;
    private static TextArea unsortedArabicNumeralsColumn;
    private static TextArea sortedArabicNumeralsColumn;
    
    /*
       creates a StringTokenizer object to tokenize each read-in line from the file into tokens (sub-strings)
     */
    private static StringTokenizer tokenizedLineOfNumerals;
    private static String currentToken;
    
    // convertThis variable holds the String of Roman Numerals read-in from the file
    private static String lineOfRomanNumerals;
    
    private static UnsortedRomanNumeralList unSortedArabicNumerals;
    private static SortedRomanNumeralList sortedArabicNumerals;
    private static RomanNumeral romanNumeral;

    /**
     * Calls the methods to initialize the GUI and TextFile variables, read numerals from the file and place them into lists, and print the contents of those lists
     * 
     * @param args The command-line arguments passed in are stored in this array
     */
    public static void main(String[] args) {
        
        initializeGUIandFile();
        readNumeralsFromFileAndPlaceIntoLists();
        printListContentsToGUI();
       
    } // main
    
    /**
     * Instantiates a new TextFileInput object, new UnSortedRomanNumeralList object and new SortedRomanNumeralList object (which both extend class RomanNumeralList), 
     * and initializes the GUI's title, size, content-pane, sets the grid layout to one row and three columns, and adds the text areas for each column of 
     * numerals to the content-pane
     */
    private static void initializeGUIandFile() {
        
        numeralsRomanArabicGUI = new RomanNumeralGUI("Sorted vs. Unsorted Roman-Arabic Numerals", 400, 200, 100, 100);
        numeralsContentPane = numeralsRomanArabicGUI.getContentPane();
        romanNumeralsColumn = new TextArea();
        unsortedArabicNumeralsColumn = new TextArea();
        sortedArabicNumeralsColumn = new TextArea();
        numeralsContentPane.add(romanNumeralsColumn);
        numeralsContentPane.add(unsortedArabicNumeralsColumn);
        numeralsContentPane.add(sortedArabicNumeralsColumn);
        numeralsFile = new TextFileInput("input.txt");
        unSortedArabicNumerals = new UnsortedRomanNumeralList();
        sortedArabicNumerals = new SortedRomanNumeralList();
        
        
    } // method initializeGUIandFile

    /**
     * Reads each line of Roman Numerals from the input file, tokenizes them into tokens (sub-strings) separated by commas, appends each token (Roman Numeral)
     * of the current tokenized line of Roman Numerals into the Roman Numerals column of the GUI, and places each token (Roman Numeral) of the current tokenized
     * line of Roman Numerals into the unSortedArabicNumerals and sortedArabicNumerals Linked Lists
     */
    private static void readNumeralsFromFileAndPlaceIntoLists() {
        
        lineOfRomanNumerals = numeralsFile.readLine(); // read-in the first line from the file of Roman numerals
        /* 
           tokenizes the read-in line of Roman Numerals separated by commas from the file into tokens, or sub-strings, if the read-in line is not equal to null
         */
        if (lineOfRomanNumerals != null) tokenizedLineOfNumerals = new StringTokenizer(lineOfRomanNumerals, ",");
        /*
           tells the user that there are no numerals to display if the first line of the file is null
         */
        else numeralsRomanArabicGUI.setTitle("Empty File - No Numerals to Display!");
        
        while (lineOfRomanNumerals != null) { // loops until there are no more Roman numerals to read-in from the file
            
            currentToken = tokenizedLineOfNumerals.nextToken(); // stores the current token (Roman Numeral) of the read-in line in the currentToken variable
            romanNumeralsColumn.append(currentToken + "\n"); // appends the first token in the read-in line to the Roman Numerals Column in the GUI
            
            romanNumeral = new RomanNumeral(currentToken); // instantiates a RomanNumeral object passing in the current token (Roman Numeral) of the read-in line
            unSortedArabicNumerals.append(romanNumeral); // appends the romanNumeral object holding the current token (Roman Numeral) of the read-in line to the unSortedArabicNumerals list
            sortedArabicNumerals.add(romanNumeral); // adds the romanNumeral object holding the current token (Roman Numeral) of the read-in line to the sortedArabicNumerals list
            
            if (tokenizedLineOfNumerals.hasMoreTokens()) continue; // if the tokenized line read-in from the file has more tokens to display, then the while-loop continues and waits until there are no more tokens left before reading the next line of the file
            else {
                lineOfRomanNumerals = numeralsFile.readLine(); // read-in the next line of Roman numerals from the file
                if (lineOfRomanNumerals != null) tokenizedLineOfNumerals = new StringTokenizer(lineOfRomanNumerals, ",");
            }
            
        } // while-loop
        
    } // method readandDisplayNumeralsFromFileToGUI
    
    /**
     * Calls the printListToGUI method from class RomanNumeralList to print the contents of both the unsorted and sorted Linked Lists of Arabic Numerals to their
     * respective columns in the Roman-Arabic Numerals GUI
     */
    private static void printListContentsToGUI() {
        
        unSortedArabicNumerals.printListToGUI(unsortedArabicNumeralsColumn);
        sortedArabicNumerals.printListToGUI(sortedArabicNumeralsColumn);
        
    }
    
} // class Project2
