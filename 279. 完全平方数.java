/* 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。
例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。 */

// 方法一：动态规划
/* dp[i] 表示最少需要多少个数的平方来表示整数 i */
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        for(int i = 1; i <= n; i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i; j++){
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
}

// 方法二：数学
/* 四平方和定理证明了任意一个正整数都可以被表示为至多四个正整数的平方和。
 * 当且仅当 n=4k × (8m+7) 时，n 可以被表示为至多三个正整数的平方和。
 * 因此，当 n=4k × (8m+7) 时，n 只能被表示为四个正整数的平方和。此时我们可以直接返回 4。
 */
class Solution {
    public int numSquares(int n) {
        if (isPerfectSquare(n)) {
            return 1;
        }
        if (checkAnswer4(n)) {
            return 4;
        }
        for (int i = 1; i * i <= n; i++) {
            int j = n - i * i;
            if (isPerfectSquare(j)) {
                return 2;
            }
        }
        return 3;
    }

    // 判断是否为完全平方数
    public boolean isPerfectSquare(int x) {
        int y = (int) Math.sqrt(x);
        return y * y == x;
    }

    // 判断是否能表示为 4^k*(8m+7)
    public boolean checkAnswer4(int x) {
        while (x % 4 == 0) {
            x /= 4;
        }
        return x % 8 == 7;
    }
}
