// this must be imported to allow the printListToGUI method to have TextArea objects as formal parameters
import java.awt.*;

public class SortedRomanNumeralList extends RomanNumeralList {
    
    /**
     * Adds a new node containing a RomanNumeral object as data to a RomanNumeral Linked List such that the list remains sorted
     * 
     * @param rn The Roman Numeral data to be held inside of the new List Node that will be added to the RomanNumeral Linked List such that the list remains sorted
     */
    public void add(RomanNumeral rn) {
        ListNode newNode = new ListNode(rn, null); // creates a new ListNode object with the new RomanNumeral data
        if (last.data == null) { // evaluates to true if the last list node equals null
            last.next = newNode;
            last = newNode; // sets the last list node's reference to equal the list node holding the newly added RomanNumeral object
            length++; // increments the length of the Linked List
        } else {
            ListNode currentNode = first.next; // sets the currentNode to be equal to the last list node (first.next is the dummyNode's reference to last)
            while (currentNode != null) { // while the currentNode does not equal null
                if (currentNode.next == null) { // if the currentNode's next reference points to null, then that means currentNode is the last list node
                    /*
                       if the newly instantiated ListNode object's Arabic numeral data is greater than or equal to the currentNode's arabicNumeral data, then
                       make the currentNode's next reference point to the new ListNode object; otherwise, make the new ListNode object's next reference point to
                       the currentNode
                     */
                    if (newNode.data.getArabicNumeral() >= currentNode.data.getArabicNumeral()) currentNode.next = newNode;
                    else {
                    	first.next = newNode;
                    	newNode.next = currentNode;
                    }
                    length++; // increment the length of the linked list
                    break; // once you placed the new ListNode's RomanNumeral data in a spot such that the Linked List remains sorted, break out of the loop
                } else { // if the currentNode's next reference does not point to null
                    /*
                       if new ListNode object's Arabic numeral data is greater than or equal to the currentNode's Arabic numeral data and the new ListNode's
                       Arabic numeral data is less than or equal to the node after the currentNode's Arabic numeral data, then make the new ListNode object's
                       next reference point to the node after the currentNode and the currentNode's next reference point to the new ListNode
                     */
                    if (newNode.data.getArabicNumeral() >= currentNode.data.getArabicNumeral() && newNode.data.getArabicNumeral() <= currentNode.next.data.getArabicNumeral()) {
                        newNode.next = currentNode.next;
                        currentNode.next = newNode;
                        length++; // increment the length of the linked list
                        break; // once you placed the new ListNode's RomanNumeral data in a spot such that the Linked List remains sorted, break out of the loop
                    }
                }
                currentNode = currentNode.next; // move on to the next list node and evaluate the while loop condition
            }  
        }
    } // method add
    
} // class SortedRomanNumeralList
