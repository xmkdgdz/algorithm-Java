/* 
    给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。
    返回这一子串的长度。
    如果不存在这样的子字符串，则返回 0。
 */

// 分治
// 思路：对于字符串 s，如果存在某个字符 ch，它的出现次数大于 0 且小于 k，则任何包含 ch 的子串都不可能满足要求。
 class Solution {
    public int longestSubstring(String s, int k) {
        if (s.length() < k) {
            return 0;
        }
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (cnt[s.charAt(i) - 'a'] < k) {
                int maxLen = 0;
                for (String sub : s.split(String.valueOf(s.charAt(i)))) {
                    maxLen = Math.max(maxLen, longestSubstring(sub, k));
                }
                return maxLen;
            }
        }
        return s.length();
    }
}