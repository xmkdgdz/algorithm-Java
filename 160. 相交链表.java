// 题目：找到两个链表的第一个交点

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// 方法一（非最优，练习 set）：集合
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<ListNode>();      
        for(ListNode a = headA; a!=null; a = a.next)
            set.add(a);
        for(ListNode b = headB; b!=null; b = b.next){
            if(set.contains(b))
                return b;
        }
        return null;
    }
}

// 方法二（最巧妙)
/* 假设 不同的部分分别长 a, b, 相同的部分为 c, a>b
 * A、B 指针同时出发，走到头就换一边走一次，直到 A=B，就是所求点
 * 因为 a+c+b = b+c+a
 * 相等的地方正好是交叉点
 * 如果没有交叉点，相等的地方正好是null
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a=headA, b=headB;
        while(a!=b){
            a = a==null ? headB : a.next;
            b = b==null ? headA : b.next;
        }
        return a;
    }
}

// 方法三（和二效率一样）：差值法
/* 先算出 a, b 间的长度差值 len
 * 重新开始，让长的先走 len
 * 再一起走，直到相等
 */
class Solution {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a=headA, b=headB;
        while(a!=null && b!=null){
            a = a.next;
            b = b.next;
        }
        int len = 0;
        // a更短
        if(a == null){
            while(b != null){
                b = b.next;
                len ++;
            }
            a=headA;
            b=headB;
            while(len>0){
                b = b.next;
                len--;
            }
        }
        // a更长
        else{
            while(a != null){
                a = a.next;
                len ++;
            }
            a=headA;
            b=headB;
            while(len>0){
                a = a.next;
                len--;
            }
        }
        while(a != b){
            a = a.next;
            b = b.next;
        }
        return a;
    }
}