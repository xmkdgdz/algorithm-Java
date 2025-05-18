/* 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
  */

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
        if (left == 1) {
            return reverseN(head, right);
        }
        ListNode pre = head;
        for (int i = 1; i < left - 1; i++) {
            pre = pre.next;
        }
        pre.next = reverseN(pre.next, right - left + 1);
        return head;
    }

    public ListNode reverseN(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode pre = null, cur = head, nxt = null;
        while (n > 0 && cur != null) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
            n--;
        }
        head.next = cur;
        return pre;
    }
}