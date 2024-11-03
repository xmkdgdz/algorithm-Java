// 题目：给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。

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

/* 思路：
 * 先序遍历：[ 根节点, [左子树的先序遍历], [右子树的先序遍历] ]
 * 中序遍历：[ [左子树的中序遍历], 根节点, [右子树的中序遍历] ]
 */

// 方法一：分治思想（递归）
/* 先序遍历中 根节点为 i，左子树起点为 i+1，右子树起点为 i+1+ 左子树节点数（即 j-l）
 * 中序遍历中 根节点为 j，左子树范围 [l, j-1]，右子树范围 [j+1, r]
 */
class Solution {
    Map<Integer, Integer> inorderMap;
    int[] preorder;
    int[] inorder;    

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        inorderMap = new HashMap<>(); // 将中序遍历数组的 值 与 索引 映射，方便快速找到索引
        for(int i=0; i<inorder.length; i++)
            inorderMap.put(inorder[i], i);
        return dfs(0, 0, inorder.length-1); // root = dfs(0, 0, inorder.length-1)
    }

    TreeNode dfs(int i, int l, int r){
        if(r-l < 0) return null;
        int j = inorderMap.get(preorder[i]);
        TreeNode node = new TreeNode(preorder[i]);
        node.left = dfs(i+1, l, j-1);
        node.right = dfs (i+1+j-l, j+1, r);
        return node;
    }
}


// 方法二：迭代
/* 对于前序遍历中的任意两个连续节点 u 和 v，根据前序遍历的流程，我们可以知道 u 和 v 只有两种可能的关系：
   v 是 u 的左儿子。这是因为在遍历到 u 之后，下一个遍历的节点就是 u 的左儿子，即 v；
   u 没有左儿子，并且 v 是 u 的某个祖先节点（或者 u 本身）的右儿子。
   如果 u 没有左儿子，那么下一个遍历的节点就是 u 的右儿子。如果 u 没有右儿子，我们就会向上回溯，直到遇到第一个有右儿子（且 u 不在它的右儿子的子树中）的节点的右儿子。
   
   用一个栈和一个指针辅助指示判断
   依次枚举前序遍历中除了第一个节点以外的每个节点。
   如果 index 恰好指向栈顶节点，那么我们不断地弹出栈顶节点并向右移动 index，并将当前节点作为最后一个弹出的节点的右儿子；
   如果 index 和栈顶节点不同，我们将当前节点作为栈顶节点的左儿子；
   
   参考方法二：
   https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solutions/255811/cong-qian-xu-yu-zhong-xu-bian-li-xu-lie-gou-zao-9
 */

 class Solution {
    public TreeNode deduceTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0) return null;
        
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        int index = 0;
        for(int i=1; i<preorder.length; i++){
            TreeNode top = stack.peek();
            TreeNode node = new TreeNode(preorder[i]);
            if(top.val != inorder[index]){
                top.left = node;
            }
            else{
                while(!stack.isEmpty() && stack.peek().val == inorder[index]){
                    top = stack.pop();
                    index++;
                }
                top.right = node;
            }
            stack.push(node);
        }
        return root;
    }
}



