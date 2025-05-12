/* 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。 */

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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummpy = new ListNode(-101, head);
        ListNode p = dummpy;
        while (p != null && p.next != null && p.next.next != null) {
            if (p.next.val == p.next.next.val) {
                int x = p.next.val;
                while (p.next != null && p.next.val == x) {
                    p.next = p.next.next;
                }
            } else {
                p = p.next;
            }
        }
        return dummpy.next;
    }
}