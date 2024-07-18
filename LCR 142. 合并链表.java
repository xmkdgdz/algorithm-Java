// 题目：将两个升序排列的链表合成一个升序排列的链表

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

// 方法一：递归
class Solution {
    public ListNode trainningPlan(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = trainningPlan(l1.next, l2);
            return l1;
        } else {
            l2.next = trainningPlan(l1, l2.next);
            return l2;
        }
    }
}

// 方法二：迭代
class Solution {
    public ListNode trainningPlan(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode pre = head;
        while(l1!=null && l2!=null){
            if(l1.val <= l2.val){
                pre.next = l1;
                l1 = l1.next;
            }
            else{
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return head.next;
    }
}