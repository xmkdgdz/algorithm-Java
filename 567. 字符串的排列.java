/* 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的 排列。
如果是，返回 true ；否则，返回 false 。
换句话说，s1 的排列之一是 s2 的 子串 。 */

/* 思路：如果 窗口长度=s1长度，且字符种类、数量都符合，则是一个排列 */
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int r = 0, l = 0;
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        int valid = 0;

        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        while (r < s2.length()) {
            char c = s2.charAt(r);
            r++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            while (valid == need.size()) {
                if (r - l == s1.length()) {
                    return true;
                }
                char d = s2.charAt(l);
                l++;
                if (window.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return false;
    }
}