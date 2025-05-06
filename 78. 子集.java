/* 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 */

// 回溯
class Solution {
    int[] nums;
    List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        res = new LinkedList<>();
        dfs(new LinkedList<Integer>(), 0);
        return res;
    }

    void dfs(List<Integer> ans, int start) {
        res.add(new LinkedList<Integer>(ans));
        for (int i = start; i < nums.length; i++) {
            ans.add(nums[i]);
            dfs(ans, i + 1);
            ans.removeLast();
        }
    }

}