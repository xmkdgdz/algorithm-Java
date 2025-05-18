/* 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。 */

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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        // 计算链表长度
        int n = 0;
        for (ListNode p = head; p != null; p = p.next) {
            n++;
        }
        k = k % n;
        if (k == 0) {
            return head;
        }
        // 找到应该断开的位置
        ListNode p = head;
        ListNode pre = null;
        for (int i = 0; i < n - k; i++) {
            pre = p;
            p = p.next;
        }
        pre.next = null; // 断开
        // 把后半部分的尾部指向前半部分
        pre = p; // 保存未来的头节点
        while (p.next != null) {
            p = p.next;
        }
        p.next = head;
        return pre;
    }
}