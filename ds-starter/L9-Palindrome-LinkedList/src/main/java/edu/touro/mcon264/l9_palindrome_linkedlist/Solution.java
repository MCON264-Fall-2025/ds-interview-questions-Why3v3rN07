package edu.touro.mcon264.l9_palindrome_linkedlist;

import java.util.ArrayList;

public class Solution {
// Challenge: Determine if a singly-linked list is a palindrome (i.e., if it reads the same forwards and backwards)
// Complexity: Iterative method - O(n) time, O(1) space
// Notes: Used a LL of chars, for simplicity, and set empty, null, and single-character strings to return true by default

    public static boolean checkPalindrome(charListNode head) {
        // empty, null and single-char are true by default
        if (head == null || head.getNext() == null) { return true; }

        charListNode prev, current, next;

        // go through list to count nodes
        int count = 0;
        current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }

        // reverse pointers of first half
        prev = null;
        current = head;
        next = current.getNext();
        current.setNext(null);
        for (int i = 1; i < count/2; i++) {
            prev = current;
            current = next;

            next = current.getNext();
            current.setNext(prev);
        }
        current.setNext(prev);

        // compare values of each pair of chars, starting from center, and un-reverse pointers of first half
        boolean isPal = true;
        boolean checked = false;
        charListNode evener = (count%2==0) ? next : next.getNext(); // skip middle char in odd-length words
        while (!checked) {
             if (evener.getVal() != current.getVal()){ isPal =  false;}

             prev = current.getNext();
             current.setNext(next);
             next = current;

             if (evener.getNext() != null) {
                 current = prev;
                 evener =  evener.getNext();
             }
             else checked = true;
        }
        return isPal;
    }


    //--------------Helpers----------------

    // Simple singly-linked list node.
    public static class charListNode {
        char val;
        charListNode next;

        charListNode(char val) { this(val, null); }
        charListNode(char val, charListNode next) {
            this.val = val;
            this.next = next;
        }

        public char getVal() { return val; }
        public charListNode getNext() { return next; }
        public void setVal(char val) { this.val = val; }
        public void setNext(charListNode next) { this.next = next; }
    }

    //Generate linked list of chars from string
    public static charListNode stringToLinkedCharList(String word) {
        if (word == null || word.isEmpty() ) return null;
        ArrayList<Character> charList = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) charList.add(word.charAt(i));
        charListNode head = new charListNode(charList.getFirst());
        charListNode current = head;
        for (int i = 1; i < charList.size(); i++) {
            current.next = new charListNode(charList.get(i));
            current = current.next;
        }
        return head;
    }


}