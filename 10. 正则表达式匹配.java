/* 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
'.' 匹配任意单个字符
'*' 匹配零个或多个前面的那一个元素
所谓匹配，是要涵盖 整个 字符串 s 的，而不是部分字符串。 */

// 动态规划
class Solution {
    public boolean isMatch(String s, String p) {
        int m=s.length()+1, n=p.length()+1;
        boolean[][] dp = new boolean[m][n]; // 为了便于处理越界，0代表空字符串
        // boolean[][]初始值为false
        dp[0][0] = true;
        // s="" p的偶数位为*时可以匹配空字符串
        for(int i=2; i<n; i+=2)
            dp[0][i] = dp[0][i-2] && p.charAt(i-1) == '*';
        // dp中的i,j表示s的前i个字符和p的前j个字符
        // charAt中的i,j需要 -1
        for(int j=1; j<m; j++){
            for(int i=1; i<n; i++){
                if(p.charAt(i-1) == '*'){
                    dp[j][i] = dp[j][i-2] // p的i-1位 + * 匹配空字符串，只需要看[:-2]是否匹配
                    || (dp[j-1][i] && p.charAt(i-2) == s.charAt(j-1)) // p的i-1位是否和s的j位匹配
                    || (dp[j-1][i] && p.charAt(i-2) == '.'); // p的i-1位是 .
                }
                else{
                    dp[j][i] = (dp[j-1][i-1] && p.charAt(i-1) == s.charAt(j-1)) // p的i位和s的j位匹配
                    || (dp[j-1][i-1] && p.charAt(i-1) == '.'); // p的i位是 .
                }
            }
        }
        return dp[m-1][n-1];
    }
}