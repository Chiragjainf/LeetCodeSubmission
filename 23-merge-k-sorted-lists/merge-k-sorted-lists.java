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
    public ListNode mergeKLists(ListNode[] lists) {
        int l = 0,  r = lists.length - 1;
        if(r < 0) {
            return null;
        }
        return merge(lists, l , r);

    }

    public ListNode merge(ListNode[] lists, int l, int r) {
        //System.out.println(l  + " " + r);
        if(l == r) {
            return lists[l];
        }

        int mid = l + (r - l) / 2;

        ListNode left = merge(lists, l , mid);
        ListNode right = merge(lists, mid + 1 , r);

        return mergeTwoLists(left, right);

    }




    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) {
            return list2;
        }

        if(list2 == null) {
            return list1;
        }

        if(list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
              list2.next = mergeTwoLists(list1, list2.next);
              return list2;
        }
    }
}