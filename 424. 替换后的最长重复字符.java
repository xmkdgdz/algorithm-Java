/* 给你一个字符串 s 和一个整数 k 。你可以选择字符串中的任一字符，并将其更改为任何其他大写英文字符。该操作最多可执行 k 次。

在执行上述操作后，返回 包含相同字母的最长子字符串的长度。 */

// 符合要求的子串长度最值，可以用滑动窗口
class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0;
        int len = 0;
        int maxCount = 0;
        int[] counts = new int[26];

        while (r < s.length()) {
            int c = s.charAt(r++) - 'A';
            counts[c]++;
            maxCount = Math.max(maxCount, counts[c]);
            /* 
                为什么不需要要维护 maxCount？
                len 只有在 maxCount 增加的时候才会增大，而 l 收缩时，必定不会有更大的 len，而 r 每次扩大都会维护 maxCount 的增加，所以肯定不会错过最大的len
             */
            while (l < r && r - l > maxCount + k) {
                int d = s.charAt(l++) - 'A';
                counts[d]--;
            }
            len = Math.max(len, r - l);
        }

        return len;
    }
}