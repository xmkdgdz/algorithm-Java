/* 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 */
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

// 快慢指针
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 为了便于操作，比如需要删除头节点等情况，new一个新的头节点
        ListNode newHead = new ListNode(-1, head);
        ListNode p = newHead;
        ListNode q = newHead;
        // 快指针多走n步
        for (int i = 0; i < n; i++) {
            q = q.next;
        }
        // q.next = null, 那么此时 p.next = 倒数第n个节点，这样便于删除
        while (q.next != null) {
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;
        return newHead.next;
    }
}