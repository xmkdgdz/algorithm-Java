/* 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词的子串，返回这些子串的起始索引。
不考虑答案输出的顺序。 
s 和 p 仅包含小写字母 */

// 滑动窗口
/* 异位词：两个字符串的字符出现的次数相同 */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<Integer>();
        int sLen = s.length(), pLen = p.length();
        if (sLen < pLen) return res;
        // 起到set的作用
        int[] pSet = new int[26];
        int[] sSet = new int[26];
        // 初始化
        for(int i=0; i<pLen; i++){
            pSet[p.charAt(i) - 'a']++;
            sSet[s.charAt(i) - 'a']++;
        }
        if(Arrays.equals(pSet, sSet)) res.add(0);
        // 以pLen为窗口
        for(int i=pLen; i<sLen; i++){
            sSet[s.charAt(i-pLen) - 'a']--;
            sSet[s.charAt(i) - 'a']++;
            if(Arrays.equals(pSet, sSet)) res.add(i-pLen+1);
        }
        return res;
    }
}