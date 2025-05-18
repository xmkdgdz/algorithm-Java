/* 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，
找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。
你可以按 任意顺序 返回这些组合。
candidates 中的 同一个 数字可以 无限制重复被选取 。
如果至少一个数字的被选数量不同，则两种组合是不同的。 
对于给定的输入，保证和为 target 的不同组合数少于 150 个。 */

// 回溯法
class Solution {
    List<List<Integer>> res;
    int[] candidates;
    int target;
    int n;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        Arrays.sort(candidates);
        n = candidates.length;
        res = new LinkedList<>();
        dfs(0, new LinkedList<>(), 0);
        return res;
    }

    void dfs (int start, List<Integer> lst, int sum) {
        for (int i = start; i < n; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            int newSum = sum + candidates[i];
            if (newSum < target) {
                lst.add(candidates[i]);
                dfs(i, lst, newSum);
                lst.removeLast();
                continue;
            } else if (newSum == target) {
                lst.add(candidates[i]);
                res.add(new LinkedList<>(lst));
                lst.removeLast();
                break;
            } else {
                break;
            }
        }
    }
}