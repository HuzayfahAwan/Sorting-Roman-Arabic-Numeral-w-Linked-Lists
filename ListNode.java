
public class ListNode {

    /*
       these instance variables hold the data of each List Node and the reference to the next node in the list
     */
    RomanNumeral data;
    ListNode next;
    
    /**
     * 
     * @param d The data to be held inside of the List Node
     * @param n The reference to the next node in the list
     */
    public ListNode(RomanNumeral d, ListNode n) {
        data = d;
        next = n;
    } // constructor
    
}
