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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode curr = head, l = null, r = null, prev = head;

        int cnt = 1;
        while(cnt <= right) {
            if(cnt == left) {
                l = curr;
            }
            if(cnt == right) {
                r = curr;
            }
            cnt++;
            curr = curr.next;
        }



        while(prev != null && prev.next != l) {
            prev = prev.next;
        }

        //System.out.println(l.val + " " + r.val + " " + prev.val);

        l.next = helper(head, l, r);

        if(prev == null) {
            return r;
        }

        prev.next = r;


        return head;
        
    }

    public ListNode helper(ListNode head, ListNode left, ListNode right) {

        if(right == left) {
            return right.next;
        }

        ListNode temp = helper(head, left.next, right);

        left.next.next = left;
        left.next = null;

        return temp;
        
    }
}