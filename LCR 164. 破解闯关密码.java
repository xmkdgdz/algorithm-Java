/* 
    闯关游戏需要破解一组密码，闯关组给出的有关密码的线索是：
    一个拥有密码所有元素的非负整数数组 password
    密码是 password 中所有元素拼接后得到的最小的一个数
    请编写一个程序返回这个密码。

    示例：
    输入: password = [0, 3, 30, 34, 5, 9]
    输出: "03033459"
 */


import java.util.Arrays;

class Solution {
    public String crackPassword(int[] password) {
        // 先把整数转化为字符串存入 strs
        String[] strs = new String[password.length];
        for(int i=0; i<password.length; i++){
            strs[i] = String.valueOf(password[i]);
        }
        // 排序
        /* 对于拼接两个字符串
         * x+y > y+x 说明 x > y
         * 由此可排序出一个从小到大的strs
         */
        Arrays.sort(strs, (x, y) -> (x+y).compareTo(y+x));
        // strs 拼接为字符串得到 res
        StringBuilder res = new StringBuilder(password.length);
        for(String s: strs)
            res.append(s);
        return res.toString();
    }
}