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

// 方法一：层序
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int deep = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            for(int i=queue.size(); i>0; i--){
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            deep++;
        }
        return deep;
    }
}

// 方法二：递归
class Solution {
    public int calculateDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(calculateDepth(root.left), calculateDepth(root.right)) + 1;
    }
}