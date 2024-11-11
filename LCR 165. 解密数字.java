/* 
    现有一串神秘的密文 ciphertext，经调查，密文的特点和规则如下：
    密文由非负整数组成
    数字 0-25 分别对应字母 a-z
    请根据上述规则将密文 ciphertext 解密为字母，并返回共有多少种解密结果。
 */

// 动态规划
// 转换为字符串
class Solution {
    public int crackNumber(int ciphertext) {
        String s = String.valueOf(ciphertext);
        int a=1, b=1;
        for(int i=0; i<s.length()-1; i++){
            String tmp = s.substring(i, i+2);
            int c = b;
            if(tmp.compareTo("10")>=0 && tmp.compareTo("25")<=0){
                b += a;
            }
            a = c;
        }
        return b;
    }
}

// 直接通过 / 和 % 获得每一位
class Solution {
    public int crackNumber(int ciphertext) {
        String s = String.valueOf(ciphertext);
        int a=1, b=1;
        for(int i=0; i<s.length()-1; i++){
            String tmp = s.substring(i, i+2);
            int c = b;
            if(tmp.compareTo("10")>=0 && tmp.compareTo("25")<=0){
                b += a;
            }
            a = c;
        }
        return b;
    }
}