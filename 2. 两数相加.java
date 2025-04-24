/* 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。

请你将两个数相加，并以相同形式返回一个表示和的链表。

你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 */
/* 
    输入：l1 = [2,4,3], l2 = [5,6,4]
    输出：[7,0,8]
    解释：342 + 465 = 807.
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        int add = 0; // 记录进位
        while (l1 != null || l2 != null) {
            // 如果l1已经到头l2还有剩余，则相当于l1.val=0，继续循环
            // 虽然会多循环几次，但代码量小
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            int val = n1 + n2 + add;
            add = val / 10;
            val %= 10;
            p.next = new ListNode(val); 
            p = p.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        // 可能出现位数相同所以同时结束，但有进位的情况
        if (add == 1) {
            p.next = new ListNode(add); 
        }
        return head.next;
    }
}