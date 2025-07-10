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
    public void reorderList(ListNode head) {
        reorderListHelper(head, head);
    }

     public ListNode reorderListHelper(ListNode head, ListNode last) {

        if(last == null) {
            return head;
        }

        ListNode first = reorderListHelper(head, last.next);

        if(first == null) {
            return null;
        } else if(first == last || first.next == last) {
            last.next = null;
            return null;
        } else {
            ListNode next = first.next;
            first.next = last;
            last.next = next;
            //System.out.println(next.val + " " + last.val);
            return next;
        }
        
    }
}