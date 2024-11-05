/* 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，x^n ）。 */

// 方法一：快速幂+递归
/* 
 * 思路：
 * 直接递归实现空间复杂度为 O(n)，所以更好采用快速幂
 * x^n = x^2 ^(n//2)      n为偶数
 *     = x^2 ^(n//2) * x  n为奇数
 * 时间复杂度：O(logn)，即为递归的层数。
 * 空间复杂度：O(logn)
 */
class Solution {
    public double myPow(double x, int n) {
        long b = n; // int:[−2147483648,2147483647] n=−2147483648时，n=-n会越界，所以转为用long
        if(x == 0.0) return 0.0;
        if(b < 0){ // n<0时，转化为n>0
            b = -b;
            x = 1/x;
        }
        return pow(x, b);
    }

    public double pow(double x, long b){
        if(b == 0) return 1.0;
        double y = pow(x, b/2);
        return b%2 == 0 ? y*y : x*y*y;
    }
}

// 方法二：快速幂 + 迭代
/* 递归需要使用额外的栈空间，我们试着将递归转写为迭代。
 * n 的二进制形式：n= [2^0] + [2^1] + [2^2] + ...
 * x^n = [x^2 ^0] * [x^2 ^1] + ...
 * 时间复杂度：O(logn)，即为对 n 进行二进制拆分的时间复杂度。
 * 空间复杂度：O(1)。
 */
class Solution {
    public double myPow(double x, int n) {
        if(x == 0.0) return 0.0;
        long b = n;
        if(b < 0){
            x = 1 / x;
            b = -b;
        }
        double res = 1.0;
        while(b > 0){
            if((b & 1) == 1){ // 说明n二进制的第i位是1
                res *= x; // 乘一个 x^2 （顺序是 x^1 x^2 x^2^2 x^2^3，所以第一次只乘x，在后面平方）
            }
            // 即使第i位是0也要位移和平方，进行对下一位的判断
            x *= x;
            b >>= 1; // 右移一位
        }
        return res;
    }
}


