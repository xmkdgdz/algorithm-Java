/* 实现一个十进制数字报数程序，请按照数字从小到大的顺序返回一个整数数列，该数列从数字 1 开始，到最大的正整数 cnt 位数字结束。
 * 实际上考的应该是返回字符串结果，数字可能非常大，超过 long
 */

class Solution {
    int[] res;
    int count=0;
    public int[] countNumbers(int cnt) {
        res = new int[(int)Math.pow(10, cnt) - 1];
        for(int digit = 1; digit <= cnt; digit++){
            // 第一位1-9单独处理
            for(char first = '1'; first <= '9'; first++){
                char[] num = new char[digit];
                num[0] = first;
                // 以后的每一位0-9，递归遍历
                dfs(1, num, digit);
            }
        }
        return res;
    }

    void dfs(int index, char[] num,int digit){
        if(index == digit){
            res[count++] = Integer.parseInt(String.valueOf(num));
            return;
        }
        for(char i = '0'; i <= '9'; i++){
            num[index] = i;
            // 处理剩下的位数
            dfs(index+1, num, digit);
        }
    }
}
