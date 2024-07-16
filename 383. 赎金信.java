// 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
// 如果可以，返回 true ；否则返回 false 。
// magazine 中的每个字符只能在 ransomNote 中使用一次。
// ransomNote 和 magazine 由小写英文字母组成

// 解题思路：分别统计两个字符串中的字母个数，每个字母 magazine >= ransomNote 即可

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] chars = new int[26];
        for (char c : magazine.toCharArray()) {
            chars[c-'a']++;
        }
        for(char c: ransomNote.toCharArray()){
            chars[c-'a']--;
            if(chars[c-'a']<0){
                return false;
            }
        }
        return true;
    }
}