/* 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 */
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

// 反转链表
// O(n) 时间复杂度  O(1) 空间复杂度
class Solution {
    public boolean isPalindrome(ListNode head) {
        // 找到中间节点
        ListNode mid = middleNode(head);
        // 翻转后半部分
        ListNode tail = reverseList(mid);
        // 从头尾两端分别遍历
        // 用 tail != null，不能用 head != null：因为mid.prev->mid，没有改变，所以head的终止条件不对，会多一步
        while (tail != null) {
            if (head.val != tail.val) {
                return false;
            }
            head = head.next;
            tail = tail.next;
        }
        return true;
    }

    ListNode middleNode(ListNode head) {
        ListNode p = head;
        ListNode pre = head;
        while (p != null && p.next != null) {
            p = p.next.next;
            pre = pre.next;
        }
        return pre;
    }

    ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}