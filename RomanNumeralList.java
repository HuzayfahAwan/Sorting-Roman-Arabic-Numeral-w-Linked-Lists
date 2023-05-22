import java.awt.TextArea;

public class RomanNumeralList {

    /* 
       these instance variables create a dummy ListNode to be the head Node of the Linked List instantiated
     */
    public ListNode ln = new ListNode(null, null);
    public ListNode first = ln;
    public ListNode last = ln;
    public int length = 0;
    
    /**
     * Print the contents of the Unsorted Linked List of Arabic Numerals to a GUI TextArea
     * 
     * @param unSortedArabicNumerals The Text Area that will have the Arabic Numerals from the unsorted Linked List appended
     */
    public void printListToGUI(TextArea arabicNumerals) {
        ListNode currentNode = first.next; // accesses the list node after the dummy list node of the Linked List
        while (currentNode != null) { // keeps going until the currentNode of the Linked List is equal to null
            arabicNumerals.append(currentNode.data.getArabicNumeral() + "\n"); // appends the Arabic Numeral data of the current list node to the GUI Text Area passed in
            currentNode = currentNode.next; // moves on to the next list node and evaluates the while condition
        }
    } // method printListToGUI
    
} // class RomanNumeralList
