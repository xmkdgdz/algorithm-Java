/* 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 */

class Solution {
    List<String> res = new LinkedList<>();
    String digits;
    Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

    public List<String> letterCombinations(String digits) {
        this.digits = digits;
        if (digits.length() == 0) {
            return res;
        }
        dfs(new StringBuilder(digits.length()), 0);
        return res;
    }

    void dfs(StringBuilder sb, int i) {
        if (i == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String chars = phoneMap.get(digits.charAt(i));
        for (char c: chars.toCharArray()) {
            sb.append(c);
            dfs(sb, i + 1);
            sb.deleteCharAt(i);
        }
    }
}