/* 
    给定两棵二叉树 tree1 和 tree2，判断 tree2 是否以 tree1 的某个节点为根的子树具有 相同的结构和节点值 。
    注意，空树 不会是以 tree1 的某个节点为根的子树具有 相同的结构和节点值 。
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null) return false;
        return isSame(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }
    // 在 isSubStructure 中已经排除了根是 null 的情况，所以如果为 null 肯定是走到头了
    boolean isSame(TreeNode A, TreeNode B){
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return isSame(A.left, B.left) && isSame(A.right, B.right);
    }
}