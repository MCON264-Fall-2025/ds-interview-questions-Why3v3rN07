package edu.touro.mcon264.l9_palindrome_linkedlist;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static edu.touro.mcon264.l9_palindrome_linkedlist.Solution.*;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void testPalindrome() {
        assertTrue(checkPalindrome(stringToLinkedCharList("12344321"))); //true - even
        assertTrue(checkPalindrome(stringToLinkedCharList("123454321")));  //true - odd
    }
    @ParameterizedTest
    @ValueSource(strings = { //errors in various positions
            "12345321","12344320","1234320",
            "0234321","02344321","01234321",
            "012344321","12343210","123443210"})
    void testNonPalindrome(String str) {
        assertFalse(checkPalindrome(stringToLinkedCharList(str)));
    }
    @Test
    void testEmpty() {
        assertTrue(checkPalindrome(stringToLinkedCharList("")));//true - by default
        assertTrue(checkPalindrome(stringToLinkedCharList(null)));
    }
    @Test
    void testSingle() {
        assertTrue(checkPalindrome(stringToLinkedCharList("1")));//true - one char
    }
    @Test
    void testShort() {
        assertTrue(checkPalindrome(stringToLinkedCharList("11")));//true - two chars
        assertFalse(checkPalindrome(stringToLinkedCharList("12")));//false - two chars
        assertTrue(checkPalindrome(stringToLinkedCharList("121")));//true - three chars
    }
    @Test
    void testLong() {
       assertTrue(checkPalindrome(stringToLinkedCharList("abcdefghijklmnopqrstuvwxyzyxwvutsrqponmlkjihgfedcba"))); //true - long odd
       assertTrue(checkPalindrome(stringToLinkedCharList("abcdefghijklmnopqrstuvwxyzzyxwvutsrqponmlkjihgfedcba"))); // true - long even
    }

    @Test
    void testRestore() {
        charListNode head1 = stringToLinkedCharList("123454321");
        checkPalindrome(head1);
        charListNode head2 = stringToLinkedCharList("123454321");
        while (head2 != null) {
            assertNotNull(head1);
            assertEquals(head1.getVal(), head2.getVal());
            head1 = head1.getNext();
            head2 = head2.getNext();
        }
    }









    //----------Helper tests--------------

    @Test
    void testStrToLL() {
        String str = "123";
        charListNode head = stringToLinkedCharList(str);
        assertNotNull(head);
        for (int i = 0; i < str.length(); i++) {
            assertEquals(str.charAt(i), head.getVal());
            if (head.getNext() != null) head = head.getNext();
        }
        assertNull(head.getNext());
    }

}