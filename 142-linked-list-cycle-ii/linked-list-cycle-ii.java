/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;
        
        // Phase 1: Determine if a cycle exists
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }
        
        // If no cycle was found, return null
        if (!hasCycle) {
            return null;
        }
        
        // Phase 2: Find the entry point of the cycle
        fast = head; // Reset fast to head
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next; // Both move at 1x speed now
        }
        
        return slow; // or fast, since they are at the same node
    }
}