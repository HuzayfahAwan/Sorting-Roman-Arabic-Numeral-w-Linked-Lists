// this must be imported to allow the printListToGUI method to have TextArea objects as formal parameters
import java.awt.*;

public class UnsortedRomanNumeralList extends RomanNumeralList {
    
    /**
     * Appends to the end of the RomanNumeral Linked List a new node containing a RomanNumeral object as data
     * 
     * @param rn The Roman Numeral data to be held inside of the new List Node that will be appended to the end of the RomanNumeral Linked List
     */
    public void append(RomanNumeral rn) {
        ListNode newNode = new ListNode(rn, null); // creates a new ListNode object with the new RomanNumeral data
        last.next = newNode; // the previous node's next field will now contain a reference to the new ListNode object just instantiated
        last = newNode; // the last node of the linked list is updated to be the new list node just instantiated and appended to the end of the linked list
        length++; // increments the length of the Linked List
    } // method append
    
}
