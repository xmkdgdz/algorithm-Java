/* 给定一个字符串 s ，请你找出其中不含有重复字符的最长 子串 的长度。 */

// 方法一：滑动窗口
// 使用set
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 记录字符在当前子串是否出现过
        Set<Character> set = new HashSet<>();
        int res = 0;
        int j = 0;
        // 对于每个起始字符，每次到达重复字符j, [i++, j) 一定不重复，j可以直接继续遍历
        for(int i=0; i<s.length(); i++){
            while(j < s.length() && !set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
            }
            // 得到以i起始的最大子串
            set.remove(s.charAt(i));
            res = Math.max(j-i, res);
        }
        return res;
    }
}

// 使用map （因为是字符串，也可以用数组 int[128]）
class Solution {
    public int dismantlingAction(String arr) {
        Map<Character, Integer> dic = new HashMap<>();
        int i = -1, res = 0, len = arr.length();
        for(int j = 0; j < len; j++) {
            if (dic.containsKey(arr.charAt(j)))
                i = Math.max(i, dic.get(arr.charAt(j))); // 更新左指针 i
            dic.put(arr.charAt(j), j); // 哈希表记录字符最后出现的位置
            res = Math.max(res, j - i); // 更新结果
        }
        return res;
    }
}

// 方法二：动态规划
/* 
 * dp[j]表示以j结尾的最长子串
 * i<0 j左边无相同字符，dp[j] = dp[j-1] + 1
 * dp[j-1]<j-i 上一个相同字符（i）在dp[j-1]外，dp[j] = dp[j-1] + 1
 * dp[j-1]>=j-i 上一个相同字符（i）在dp[j-1]内，dp[j] = j-i
 */
class Solution {
    public int dismantlingAction(String arr) {
        Map<Character, Integer> dic = new HashMap<>();
        // tmp 存储 dp[j-1]
        int res = 0, tmp = 0, len = arr.length();
        for(int j = 0; j < len; j++) {
            int i = dic.getOrDefault(arr.charAt(j), -1); // 获取上一个相同字符 i
            dic.put(arr.charAt(j), j); // 更新哈希表
            tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
            res = Math.max(res, tmp); 
        }
        return res;
    }
}