// 实现一个函数来判断整数数组 postorder 是否为二叉搜索树的后序遍历结果。

/* 二叉搜索树：左子树中所有节点的值 < 根节点的值 < 右子树中所有节点的值
 * 后序遍历: [ [左子树的后序遍历] [右子树的后序遍历] 根节点 ] 
 */

// 方法一：递归分治
class Solution {
    public boolean verifyTreeOrder(int[] postorder) {
        if(postorder == null || postorder.length == 0) return true;
        int n = postorder.length;
        int root = postorder[n-1]; // 末尾是根节点
        int left, right;
        int i=0;
        while(postorder[i]<root){ // 左子树全部小于根节点
            i++;
        }
        left = i;
        while(postorder[i]>root){ // 右子树全部大于根节点
            i++;
        }
        right = i;
        if(i != n-1) return false; // 说明右边存在小于根节点的值，所以不是二叉搜索树
        // 继续检验子树是不是二叉搜索树
        return verifyTreeOrder(Arrays.copyOfRange(postorder, 0, left))
            && verifyTreeOrder(Arrays.copyOfRange(postorder, left, right));
    }
}

// 方法二：辅助单调栈
/* 从根节点开始倒序遍历
 * 如果一直单调递增，说明一直在右子树延伸
 * 当开始小于，则说明开始进入左子树
 * 通过辅助栈找到该左子结点的父节点
 * 继续遍历，所有值都应小于父节点
 */
class Solution {
    public boolean verifyTreeOrder(int[] postorder) {
        Deque<Integer> stack = new LinkedList<>();
        int root = Integer.MAX_VALUE;
        stack.push(root);
        for(int i=postorder.length-1; i>=0; i--){
            if(postorder[i]>root) return false;
            while(!stack.isEmpty() && stack.peek()>postorder[i]){
                root = stack.pop();
            }
            stack.push(postorder[i]);
        }
        return true;
    }
}