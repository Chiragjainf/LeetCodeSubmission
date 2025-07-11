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

        ListNode slow = head, fast = head, end = null;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                end = fast;
                break;
            }
        }

        if(end == null) {
          return null;
        }

        slow = head;

        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;

    }
}