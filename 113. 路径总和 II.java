/* 给你二叉树的根节点 root 和一个整数目标和 targetSum ，
找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
叶子节点 是指没有子节点的节点。 */

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
    int targetSum;
    List<List<Integer>> res;
    List<Integer> lst;
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        res = new LinkedList<>();
        lst = new LinkedList<>();
        dfs(root, 0);
        return res;
    }

    void dfs(TreeNode node, int sum){
        if(node == null){
            return;
        }
        sum += node.val;
        lst.add(node.val);
        if(sum == targetSum && node.left == null && node.right == null)
            // res.add(lst)，将此lst对象加入了res；后续lst改变时，res中的lst对象也会随之改变，因此无法实现结果记录
            // 只能采取以下方法
            res.add(new LinkedList(lst));
        // target和val正负不确定，所以必须遍历全部
        dfs(node.left, sum);
        dfs(node.right, sum);
        // 后面还有自己的兄弟节点
        lst.removeLast();
    }
}