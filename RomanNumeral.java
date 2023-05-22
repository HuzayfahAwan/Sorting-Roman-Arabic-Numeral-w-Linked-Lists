
public class RomanNumeral {
    
    /* 
       the following 1D arrays hold the Roman Numerals and their corresponding integer values (the indices match up -> index 0 of char array contains 'I' and 
       index 0 of int array contains 1, so the values correspond) 
     */
    static final int[] romanValues = {1, 5, 10, 50, 100, 500, 1000};
    static final char[] romanNumerals = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    
    /* 
       the conversionResult variable holds the integer value being accumulated as each Roman Numeral in the String gets processed, and the 
       valueOfNumeralToRight variable tracks the value of the numeral to the right so the special case can be tested later in the numeral conversion method
     */
    static int conversionResult, valueOfNumeralToRight;

    // these are the instance variables storing the Roman and Arabic Numerals
    private String romanNumeral;
    private int arabicNumeral;
    
    /**
     * This constructor initializes the instance variables romanNumeral and arabicNumeral 
     * 
     * @param rn The Roman Numeral being instantiated as an object
     */
    public RomanNumeral(String rn) {
        romanNumeral = rn;
        arabicNumeral = convertRomanNumToArabicInt(romanNumeral);
    }

    /**
     * Converts the Roman Numeral passed in to an Arabic Integer value
     *  
     * @param convertThis The Roman Numeral to be converted to an Arabic Numeral
     * @return conversionResult The Arabic Numeral (integer value) after the Roman Numeral conversion is complete
     */
    private static int convertRomanNumToArabicInt(String convertThis) {
        
        /* 
           the conversionResult variable holds the integer value being accumulated as each Roman Numeral in the String gets processed, and the 
           valueOfNumeralToRight variable tracks the value of the numeral to the right so the special case can be tested
         */
        conversionResult = 0; /* resets to 0 every time the method is called */
        
        /* 
           looping through the Roman Numeral String provided from right-to-left because the special case needs to be considered when the character to the left 
           has a smaller value than the character to its right
         */
        for (int i = (convertThis.length() - 1); i >= 0; i--) {
            
            /* 
               looping through the romanNumerals char array and checking for a match between the current Roman Numeral letter being processed and the content of
               the current index of the char array
             */
            for (int j = 0; j < romanNumerals.length; j++) {
                
                /* 
                   if the outer-loop processing the Roman Numeral String is on its first iteration, then the special case where one checks if the letter to the 
                   left's value is less than the letter to its right does not need to be considered
                 */
                if (i == (convertThis.length() - 1) && convertThis.charAt(i) == romanNumerals[j]) {
                    
                    conversionResult += romanValues[j]; /* adding the matched integer value of the current Roman Numeral letter to the conversionResult variable */
                        
                    /* 
                       if it's not the last iteration of the Roman Numeral String being processed, then the matched integer value of the current Roman 
                       Numeral letter is stored in this variable to be used for the next iteration's comparison of letters
                     */
                    if (i != 0) valueOfNumeralToRight = romanValues[j];
                        
                    break; // once a match is found, the loop should break to prevent incorrect adding or subtracting to the conversionResult variable
                    
                } else {
                    
                    if (convertThis.charAt(i) == romanNumerals[j] && romanValues[j] < valueOfNumeralToRight) {
                        
                        conversionResult -= romanValues[j]; /* subtracting the matched integer value of the current Roman Numeral letter to the conversionResult variable */
                        
                        /* 
                           if it's not the last iteration of the Roman Numeral String being processed, then the matched integer value of the current Roman 
                           Numeral letter is stored in this variable to be used for the next iteration's comparison of letters 
                        */
                        if (i != 0) valueOfNumeralToRight = romanValues[j];
                        
                        break; // once a match is found, the loop should break to prevent incorrect adding or subtracting to the conversionResult variable
                    
                    } else if (convertThis.charAt(i) == romanNumerals[j] && romanValues[j] >= valueOfNumeralToRight) {
                        conversionResult += romanValues[j]; // adding the matched integer value of the current Roman Numeral letter to the conversionResult variable
                        
                        /* 
                           if it's not the last iteration of the Roman Numeral String being processed, then the matched integer value of the current Roman 
                           Numeral letter is stored in this variable to be used for the next iteration's comparison of letters
                         */
                        if (i != 0) valueOfNumeralToRight = romanValues[j];
                        
                        break; // once a match is found, the loop should break to prevent incorrect adding or subtracting to the conversionResult variable
                    }
                
                }
            
            } // inner-loop
            
        } // outer-loop
        
        return conversionResult;
        
    } // method convertRomanNumToArabicInt
    
    /**
     * Compares two RomanNumeral objects to see if they are equal in value, or if one is either less than or greater than the other
     * 
     * @param other The RomanNumeral object getting passed in as an argument for comparison
     * @return 0 if the objects are equal, -1 if the object the method is being applied to is less than the object getting passed in as an argument, and 1 if the object the method is being applied to is less than the object getting passed in as an argument
     */
    public int compareTo(RomanNumeral other) {
        if (this.arabicNumeral == other.arabicNumeral) return 0;
        else if (this.arabicNumeral < other.arabicNumeral) return -1;
        else if (this.arabicNumeral > other.arabicNumeral) return 1;
        return 0;
    } // method compareTo
    
    /**
     * Compares two objects to see if they are equal in value or not 
     * 
     * @param other The object getting passed in as an argument for an equality check
     * @return true if the objects are equal, or false if the objects are not equal
     */
    public boolean equals(Object other) {
        if (other != null && this.getClass().equals(other.getClass()) && this.romanNumeral.equals(((RomanNumeral) other).romanNumeral)) return true;
        return false;
    } // method equals
 
    /**
     * Returns the String representation of the Roman Numeral attribute of the object and the Arabic Numeral attribute of the object
     * 
     * @return The String representation of the object
     */
    public String toString() {
        return "Roman Numeral: " + romanNumeral + "\nArabic Numeral: " + String.valueOf(arabicNumeral);
    } // method toString()
    
    /**
     * Retrieves the Arabic Numeral of the object
     * 
     * @return The Arabic Numeral of the object
     */
    public int getArabicNumeral() {
        return arabicNumeral;
    } // method getArabicNumeral
    
    /**
     * Retrieves the Roman Numeral of the object
     * 
     * @return The Roman Numeral of the object
     */
    public String getRomanNumeral() {
        return romanNumeral;
    } // method getRomanNumeral
    
    /**
     * Replaces the previous String value of romanNumeral with a new valid Roman Numeral String 
     * 
     * @param rn The Roman Numeral replacing the previous String value of the object
     */
    public void setRomanNumeral(String rn) {
        for (int i = 0; i < rn.length(); i++) {
            char currentCharacter = rn.charAt(i);
            int count = 0;
            for (int j = 0; j < romanNumerals.length; j++) {
                if (currentCharacter != romanNumerals[j]) count++;
            }
            if (count == romanNumerals.length) throw new IllegalArgumentException("Bad input for Roman Numeral.");
        }
        romanNumeral = rn;
    } // method setRomanNumeral
    
} // class RomanNumeral
