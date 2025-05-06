/* 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 */

// 回溯
class Solution {
    int[] nums;
    List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        res = new LinkedList<>();
        dfs(new LinkedList<Integer>(), new boolean[nums.length]);
        return res;
    }

    void dfs(List<Integer> ans, boolean[] selected) {
        // 终止
        if (ans.size() == nums.length) {
            res.add(new LinkedList<Integer>(ans));
            return;
        }
        
        for (int i = 0; i < nums.length; ++i) {
            if (!selected[i]) {
                ans.add(nums[i]);
                selected[i] = true;
                dfs(ans, selected);
                // 撤销
                selected[i] = false;
                ans.removeLast();
            }
        }
    }
}