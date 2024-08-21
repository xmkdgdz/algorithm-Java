// 题目：判断是否为平衡二叉树

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

// 后序遍历，从底至顶返回深度，减少运算量
class Solution {

    public boolean isBalanced(TreeNode root) {
        return deep(root) != -1;
    }

    int deep(TreeNode node){
        if(node == null) return 0; 
        int left = deep(node.left);
        if(left == -1) return -1;
        int right = deep(node.right);
        if(right == -1) return -1;
        int h = left - right;
        if(h < -1 || h > 1) return -1;
        return Math.max(left, right) + 1;
    }

}