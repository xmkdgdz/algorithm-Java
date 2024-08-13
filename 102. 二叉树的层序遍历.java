/*  题目：请按照从左到右的顺序返回每一层彩灯编号，每一层的结果记录于一行。
    
    示例：
    输入：root = [8,17,21,18,null,null,6]
    输出：[[8],[17,21],[18,6]]
 */ 

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

// 方法一：广度优先
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            // 此时队列内全部都是这一层的，把这一层出队入队
            for(int i=queue.size(); i>0; i--){
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            res.add(tmp);          
        }
        return res; 
    }
}

// 方法二：深度优先
// 每次记录深度
class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> decorateRecord(TreeNode root) {
        dfs(0, root);
        return res;
    }

    void dfs(int deep, TreeNode node){
        if(node == null) return;
        // deep == res.size() 说明是新的一行，需要添加 list
        if(deep == res.size()){
            List<Integer> tmp = new ArrayList<>();
            tmp.add(node.val);
            res.add(tmp);
        }
        else{
            res.get(deep).add(node.val);
        }
        dfs(deep+1, node.left);
        dfs(deep+1, node.right);
    }
}