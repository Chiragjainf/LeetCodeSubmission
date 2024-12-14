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


    public ListNode mergeKListsHelper(ListNode[] lists, int l, int r) {

        if(l > r) {
            return null;
        }

        if(l == r) {
            return lists[l];
        }

        int mid = l + (r - l) / 2;
        ListNode list1 = mergeKListsHelper(lists, l , mid);
        ListNode list2 = mergeKListsHelper(lists, mid + 1 , r);
        return merge(list1, list2);
        
    }


    public ListNode mergeKLists(ListNode[] lists) {
        int l = 0, r = lists.length - 1;
        return mergeKListsHelper(lists, l ,r);
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) {
            return null;
        } 
        if(list1 == null) {
            return list2;
        }
        if(list2 == null) {
            return list1;
        }

        if(list1.val <= list2.val) {
            list1.next = merge(list1.next,list2);
            return list1;
        }
        else {
            list2.next = merge(list1,list2.next);
            return list2;
        }
    }
}