// 题目：节点多一个random部分，指向随机其他节点或null。复制该链表。

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

// 方法一：HashMap
// 创建老链表和新链表节点间的映射，需遍历两遍
// 空间复杂度 O(n)
class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<Node, Node>();
        for(Node p=head; p!=null; p=p.next)
            map.put(p, new Node(p.val));
        for(Node p=head; p!=null; p=p.next){
            map.get(p).next = map.get(p.next);
            map.get(p).random = map.get(p.random);
        }
        return map.get(head);
    }
}

// 方法二：拼接 + 拆分
// 三轮遍历链表，时间复杂度相同
// 空间复杂度 O(1)
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        // 1.复制各节点，拼装在原节点后
        Node p = head;
        while(p != null){
            Node node = new Node(p.val);
            node.next = p.next;
            p.next =node;
            p=p.next.next;
        }
        // 2.再遍历一遍，完成新节点 random 的指向
        p = head;
        while(p != null){
            if(p.random != null)
                p.next.random = p.random.next;
            p = p.next.next; 
        }
        // 3.拆出新链表，还原旧链表
        p = head;
        Node n = p.next;
        Node q = n;
        while(q.next != null){
            p.next = q.next;
            p = p.next;
            q.next = p.next;
            q = q.next;
        }
        p.next = null; // 单独处理原链表尾节点
        return n;
    }
}