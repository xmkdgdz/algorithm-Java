/* 给定一个正整数 n，编写一个函数，获取一个正整数的二进制形式并返回其二进制表达式中 
设置位的个数（也被称为汉明重量）。
即：一个整数二进制形式中1的数量 */

// 方法一：逐位判断
// 时间复杂度 O(log2(n))
class Solution {
    public int hammingWeight(int n) {
        int res = 0;
        // 条件是 !=0 而不是 >0，因为可能是负数例如 1111111111...
        while(n != 0){
            if((n & 1) == 1) res++;
            n >>= 1;
        }
        return res;
    }
}

// 方法二：巧用 n&(n−1)
// 时间复杂度 O(M) M为1的个数
/* n-1 将最右边的一个1变成 0，1右边的0全变成1 
 * n & x 将最右边 变成1的0 变回0
 * n & (n-1) 的目的是将最右边1变成0
 * 每次循环直接找到一个1
 * 时间复杂度比方法一还小
 */
public class Solution {
    public int hammingWeight(int n) {
        int res = 0;
        while(n != 0){
            res++;
            n = n & (n-1);
        }
        return res;
    }
}