/* 题目：给你一个二叉树的根节点 root ， 检查它是否轴对称。 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// 方法一：递归
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isMiror(root.left, root.right);
    }
    
    boolean isMiror(TreeNode a, TreeNode b){
        if(a == null && b == null) return true;
        if(a == null || b == null) return false;
        if(a.val != b.val) return false;
        return isMiror(a.left, b.right) && isMiror(a.right, b.left);
    }
}

// 方法二：迭代
class Solution {
    public boolean checkSymmetricTree(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while(!queue.isEmpty()){
            TreeNode a = queue.poll();
            TreeNode b = queue.poll();
            if(a == null && b == null) continue;
            if(a == null || b == null || a.val != b.val) return false;

            queue.offer(a.left);
            queue.offer(b.right);

            queue.offer(a.right);
            queue.offer(b.left);
        }
        return true;
    }
}