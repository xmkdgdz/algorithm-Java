/* 
    给定一个链表的头节点 head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
    不允许修改 链表。
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// 方法一：哈希表
// 空间复杂度：O(N)
// 遍历链表中的每个节点，并将它记录下来；一旦遇到了此前遍历过的节点，就证明有环，且该点是入环的位置
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode pos = head;
        Set<ListNode> visited = new HashSet<ListNode>();
        while (pos != null) {
            if (visited.contains(pos)) {
                return pos;
            } else {
                visited.add(pos);
            }
            pos = pos.next;
        }
        return null;
    }
}

// 方法二：双指针
// 空间复杂度：O(1)
/* 
    设直线部分为a，环为b，
    入环点应该在 a+k*b
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        /* 
            快慢指针相遇
            fast = 2*slow
            fast = slow + k*b (fast比slow多k圈)
            解得：slow=k*b, fast=2*k*b
         */
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        /* 
            因为入环点在a+k*b，只需让slow再走a
            将fast放回head，两指针都只走一步，相遇时：
            fast = a
            slow = k*b + a
            两者相遇，且正好在入环点
         */
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}