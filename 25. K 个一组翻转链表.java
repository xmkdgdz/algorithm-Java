/* 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 */

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

/* 1. 先反转以 head 开头的 k 个元素。这里可以复用前面实现的 reverseN 函数
2. 将第 k + 1 个元素作为 head 递归调用 reverseKGroup 函数。
3. 将上述两个过程的结果连接起来。 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode a = head, b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) {
                return a;
            }
            b = b.next;
        }
        ListNode newHead = reverseN(a, k);
        a.next = reverseKGroup(b, k);
        return newHead;
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
        return pre;
    }
}