/* 
数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 

输入：n = 3
输出：["((()))","(()())","(())()","()(())","()()()"]
*/

// 回溯法
class Solution {
    List<String> res = new LinkedList<>();

    public List<String> generateParenthesis(int n) {
        // 可以放几个左括号和几个右括号
        dfs(new StringBuilder(), n, n);
        return res;
    }

    void dfs(StringBuilder sb, int l, int r) {
        if (l == 0 && r == 0) {
            res.add(sb.toString());
        }
        if (l > 0) {
            sb.append("(");
            dfs(sb, l-1, r);
            sb.deleteCharAt(sb.length() - 1);
        }
        // 放置的右括号数量必须小于等于左括号
        if (r > l) {
            sb.append(")");
            dfs(sb, l, r - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}