/* 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。 */
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

// 迭代
// 空间复杂度 O(1)
class Solution {
    public ListNode swapPairs(ListNode head) {
        // 通过一个指向头节点的节点简化特殊情况
        ListNode newHead = new ListNode(-1, head);
        ListNode pre = newHead;
        // 如果pre后不存在两个节点，交换结束
        while (pre.next != null && pre.next.next != null) {
            // 一般交换逻辑，交换pre后的两个节点
            swapListNode(pre);
            pre = pre.next.next;
        }
        return newHead.next;
    }
    void swapListNode(ListNode pre) {
        ListNode p = pre.next;
        ListNode q = p.next;
        pre.next = q;
        p.next = q.next;
        q.next = p;
    }
}

// 递归
// 空间复杂度 O(n)
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }
}