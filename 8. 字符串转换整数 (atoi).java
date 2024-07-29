/* 
    请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数。

    函数 myAtoi(string s) 的算法如下：

    空格：读入字符串并丢弃无用的前导空格（" "）
    符号：检查下一个字符（假设还未到字符末尾）为 '-' 还是 '+'。如果两者都不存在，则假定结果为正。
    转换：通过跳过前置零来读取该整数，直到遇到非数字字符或到达字符串的结尾。如果没有读取数字，则结果为0。
    舍入：如果整数数超过 32 位有符号整数范围 [−2^31,  2^31 − 1] ，需要截断这个整数，使其保持在这个范围内。
    具体来说，小于 −2^31 的整数应该被舍入为 −2^31 ，大于 2^31 − 1 的整数应该被舍入为 2^31 − 1 。
    返回整数作为最终结果。
 */

 class Solution {
    public int myAtoi(String s) {
        int i = 0, flag = 1, res = 0, bndry = Integer.MAX_VALUE / 10;;
        // 跳过空格
        while(i<s.length() && s.charAt(i) == ' ') i++;
        // 处理符号
        if(i<s.length() && s.charAt(i) == '-'){
            flag = -1;
            i++;
        }
        else if(i<s.length() && s.charAt(i) == '+'){
            i++;
        }
        // 读入数字
        while(i<s.length()){
            if(s.charAt(i) < '0' || s.charAt(i) > '9') break;
            int d = s.charAt(i) - '0';
            // 处理边界
            /* 原理：2^31-1 = 2147483647，res 是除去个位数的其他位
             * 如果 res > Integer.MAX_VALUE/10，那么一定越界
             * 或者 res = Integer.MAX_VALUE/10，但个位数 d > Integer.MAX_VALUE%10=7，也越界
             */
            if(res > bndry || (res == bndry && d > 7)){
                // 不需要单独区分正负越界。因为如果负数为 -2147483648，虽然没越界被当作越界处理，但是依旧返回 Integer.MIN_VALUE，没区别
                res = flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                break;
            }
            res = res*10 + d;
            i++;
        }

        return res*flag;
    }
}