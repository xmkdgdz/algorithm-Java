/* 题目：给定一个头节点为 head 的链表，查找并返回倒数第 cnt 个节点。 */

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

//  方法一：普通方法。先遍历统计链表长度，记为 n，再走相应步数。
class Solution {
    public ListNode trainingPlan(ListNode head, int cnt) {
        int n=0;
        for (ListNode p=head; p!=null; p=p.next)
            n++;
        ListNode p = head;
        for(int i=0; i < n-cnt; i++)
            p = p.next;
        return p;
    }
}

// 方法二：快慢指针。快指针先走 cnt 步，然后两个指针一起走，当快指针走到头，慢指针就指向了倒数第 cnt 个。
// 更巧妙，但性能一样。
class Solution {
    public ListNode trainingPlan(ListNode head, int cnt) {
        ListNode p=head, q=head;
        for(int i=0; i<cnt; i++){
            q = q.next;
        }
        while(q!=null){
            p = p.next;
            q = q.next;
        }
        return p;
    }
}