/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode nextNode = curr.next; // Step 1: Save the next node
            curr.next = prev;              // Step 2: Reverse the link
            prev = curr;                   // Step 3: Move prev forward
            curr = nextNode;               // Step 4: Move curr forward
        }
        
        return prev; // prev will be pointing to the new head
    }
}