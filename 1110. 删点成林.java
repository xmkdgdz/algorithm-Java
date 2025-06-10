/* 给出二叉树的根节点 root，树上每个节点都有一个不同的值。

如果节点值在 to_delete 中出现，我们就把该节点从树上删去，最后得到一个森林（一些不相交的树构成的集合）。

返回森林中的每棵树。你可以按任意顺序组织答案。 */

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

class Solution {

    Set<Integer> delSet = new HashSet<>();
    List<TreeNode> res = new LinkedList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for (int d : to_delete) {
            delSet.add(d);
        }
        traverse(root, false);
        return res;
    }

    TreeNode traverse(TreeNode root, boolean hasParent) {
        if (root == null) {
            return null;
        }
        // 判断是否需要被删除
        boolean deleted = delSet.contains(root.val);
        // 没有父节点且不需要被删除，就是一个新的根节点
        if (!deleted && !hasParent) {
            res.add(root);
        }
        // 遍历左右子树
        root.left = traverse(root.left, !deleted);
        root.right = traverse(root.right, !deleted);
        // 如果需要被删除，返回 null 给父节点
        return deleted ? null : root;
    }
}