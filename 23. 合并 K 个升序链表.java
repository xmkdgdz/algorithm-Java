/* 给你一个链表数组，每个链表都已经按升序排列。
请你将所有链表合并到一个升序链表中，返回合并后的链表。 */

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

// 分治合并
// 时间复杂度：O(kn * logk) 空间复杂度：O(logk) 
class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length-1);
    }

    // 分治
    ListNode merge(ListNode[] lists, int l, int r){
        if(l == r) return lists[l];
        if(l > r) return null;
        int m = l+(r-l)/2;
        return mergeTwoLists(merge(lists, l, m), merge(lists, m+1, r));
    }

    // 合并两个升序链表
    ListNode mergeTwoLists(ListNode a, ListNode b){
        if(a == null || b == null)
            return a != null ? a : b;
        ListNode head = new ListNode(0);
        ListNode p = head;
        while(a!=null && b!=null){
            if(a.val < b.val){
                p.next = a;
                a = a.next;
            }else{
                p.next = b;
                b = b.next;
            }
            p = p.next;
        }
        p.next = (a != null ? a : b);
        return head.next;
    }
}