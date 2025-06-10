/* 给你一个整数 n ，请你找出所有可能含 n 个节点的 真二叉树 ，并以列表形式返回。答案中每棵树的每个节点都必须符合 Node.val == 0 。

答案的每个元素都是一棵真二叉树的根节点。你可以按 任意顺序 返回最终的真二叉树列表。

真二叉树 是一类二叉树，树中每个节点恰好有 0 或 2 个子节点。 */

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

/* 如果你想生成一棵 n 个节点的满二叉树，首先要固定根节点，然后组装左右子树，根节点加上左右子树节点之和应该等于 n。 */
class Solution {
    // 备忘录，记录 n 个节点能够组合成的所有可能二叉树
    List<TreeNode>[] memo;

    public List<TreeNode> allPossibleFBT(int n) {
        memo = new LinkedList[n+1]; // 必须用实现类创建数组
        return build(n);
    }

    List<TreeNode> build(int n) {
        List<TreeNode> res = new LinkedList<>();
        if (n % 2 == 0) {
            return res; 
        }
        if (n == 1) {
            res.add(new TreeNode(0));
            return res;
        }
        if (memo[n] != null) {
            return memo[n];
        }
        // 只能遍历解。其实题目中n<=20说明该题很可能只有遍历解
        for (int i = 1; i < n; i += 2) {
            List<TreeNode> leftTrees = build(i);
            List<TreeNode> rightTrees = build(n-i-1);
            for (TreeNode leftTree: leftTrees) {
                for (TreeNode rightTree: rightTrees) {
                    TreeNode root = new TreeNode(0, leftTree, rightTree);
                    res.add(root);
                }
            }
        }
        return res;
    }

}