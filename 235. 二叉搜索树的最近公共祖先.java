/* 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 一个节点也可以是它自己的祖先
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

/* 
    思路：
    若 root 是 p , q 的 最近公共祖先 ，则只可能为以下三种情况之一：
    p 和 q 在 root 的子树中，且分列 root 的 异侧（即分别在左、右子树中）；
    p = root 且 q 在 root 的左或右子树中；
    q = root 且 p 在 root 的左或右子树中；
 */

// 方法一：迭代
// 空间复杂度 O(1)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         while(true){
            // p,q 都在 root 的右子树中
            if(p.val < root.val && q.val < root.val)
                root = root.left;
            // p,q 都在 root 的左子树中
            else if(p.val > root.val && q.val > root.val)
                root = root.right;
            // 找到 root
            else
                break;
         }
         return root;
    }
}

// 方法二：递归
// 空间复杂度 O(N)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        else if(p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);
        else
            return root;
    }
}

