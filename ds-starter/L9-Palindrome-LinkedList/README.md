#  Challenge L9 - Palindrome Linked List

##  Problem Statement
> Given the head of a singly linked list, determine whether the list is a palindrome (i.e., whether it reads the same forwards and backwards).

---

##  Assumptions
- Expected Complexity: Time - O(n),  Space - O(1)
- Each node contains a char value and a reference to the next node.
- The linked list should be restored to its original state before the code completes.
- Empty, null, and single-character lists will return true by default.
- The method is case-sensitive.

---

##  Conceptual Solution
1. **Count total nodes:**
   Traverse the list, incrementing a counter.
2. **Reverse pointers of first half:**
   Go through half the list, switching each node's pointer to point to the previous node.
3. **Compare values and restore pointers:**
   Starting from the middle and working your way out, compare values of char pairs to determine if the list is a palindrome. Restore the first half's pointers as you pass.
4. **Return true or false:**
   If any char pair did not match, return false; otherwise, return true.

---

##  Example
### Input: Head of Linked List: ###
<pre>T > E > S > T > S > E > T > null  </pre>
### Expected Output: True  ###

### Explanation: ### 
Input the head node into checkPalindrome()  
Node count will be 7, so the pointers of the first 3 nodes will be reversed:  
Linked List state: <pre>null < T < E < S &nbsp; T > S > E > T > null  </pre>
List length is odd, so center node (second 'T') will be skipped  
Starting from center, check that each pair of nodes' values are equal. Un-reverse first half's pointers as you go.  
S=S, E=E,  T=T  
Stop when pointers point to null.  
Linked List restored to: <pre> T > E > S > T > S > E > T > null </pre>
All pairs matched, so return true. 
