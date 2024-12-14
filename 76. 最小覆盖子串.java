/* 
给你一个字符串 s 、一个字符串 t 。
返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
注意：
对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
如果 s 中存在这样的子串，我们保证它是唯一的答案。 */

// 滑动窗口
class Solution {
    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen < tLen) return "";
        // 记录 t 中出现的字符和 wnd 中出现字符的差值
        HashMap<Character, Integer> need = new HashMap<>();
        // 有 less 种字符未覆盖
        int less = 0;
        // 把t中需要的字符初始化
        for (char c: t.toCharArray()) {
            if (!need.containsKey(c)) {
                less++; // 一共需要多少种字符
            }
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int l = 0, r = 0;
        // ans 是 ans 长度
        int ans = Integer.MAX_VALUE, ansL = -1, ansR = -1;

        while (r < sLen) {
            char c = s.charAt(r);
            need.put(c, need.getOrDefault(c, 0) - 1);
            // 代表该种字符已覆盖
            if (need.get(c) == 0) less--;
            // 所有字符都已覆盖，那么l++，开始收缩
            while (less == 0) {
                // 更新答案
                if (r - l + 1 < ans) {
                    ans = r - l + 1;
                    ansL = l;
                    ansR = r + 1;
                }
                // 移动l
                /* 注意，即使d是需要的字符，也要移动
                 * 因为后面可能出现各种情况，此时不再覆盖不代表不是最好
                 */
                char d = s.charAt(l);
                // d是需要的字符，移动后必定该字符无法覆盖
                if (need.get(d) == 0) {
                    less++;
                }
                need.put(d, need.get(d) + 1);
                l++;
            }
            r++;
        }

        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }
}