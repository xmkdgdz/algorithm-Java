/* 
    有效数字（按顺序）可以分成以下几个部分：
    1. 若干空格
    2. 一个 小数 或者 整数
    3. （可选）一个 'e' 或 'E' ，后面跟着一个 整数
    4. 若干空格

    小数（按顺序）可以分成以下几个部分：
    1. （可选）一个符号字符（'+' 或 '-'）
    2. 下述格式之一：
        1. 至少一位数字，后面跟着一个点 '.'
        2. 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
        3. 一个点 '.' ，后面跟着至少一位数字

    整数（按顺序）可以分成以下几个部分：
    1. （可选）一个符号字符（'+' 或 '-'）
    2. 至少一位数字

    部分有效数字列举如下：["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"]
    部分无效数字列举如下：["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"]

    给你一个字符串 s ，如果 s 是一个 有效数字 ，请返回 true 。 
 */

// 方法一：纯 if-else 逻辑
class Solution {
    public boolean validNumber(String s) {
        int i=0;
        // 跳过空格
        while(i<s.length() && s.charAt(i) == ' ') i++;
        // 符号
        if(i<s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) i++;
        // 第一个是整数或小数
        if(isDecimal(i, s) != -1) i = isDecimal(i, s);
        else if(isInt(i, s) != -1) i = isInt(i, s);
        else return false;
        // 有 e
        if(i<s.length() && (s.charAt(i) == 'E' || s.charAt(i) == 'e')){
            i++;
            // 符号
            if(i<s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) i++;
            // 整数
            if(isInt(i, s) != -1) i = isInt(i, s);
            else return false;
        }
        // 跳过空格
        while(i<s.length() && s.charAt(i) == ' ') i++;
        if(i == s.length()) return true;
        return false;
    }
    // 是不是整数（不管符号），返回索引位置
    int isInt(int i, String s){
        // 第一个数字  
        if(i<s.length() && Character.isDigit(s.charAt(i))) i++;
        else return -1;
        // 其他数字
        for(; i<s.length() && Character.isDigit(s.charAt(i)); i++);
        return i;
    }
    // 是不是小数（不管符号），返回索引位置
    int isDecimal(int i, String s){
        // 一个点 '.' ，后面跟着至少一位数字
        if(i < s.length() && s.charAt(i) == '.'){
            i = isInt(i+1, s);
            if(i == -1) return -1;
            return i;
        }
        // 至少一位数字，后面跟着一个点 '.', 后面随意
        i = isInt(i, s);
        if(i == -1) return -1;
        if(i < s.length() && s.charAt(i) == '.')
            return isInt(i+1, s) == -1 ? i+1 : isInt(i+1, s);
        return -1;
    }
}

// 方法二：有限状态自动机
/* 思路：https://leetcode.cn/leetbook/read/illustration-of-algorithm/lh6686/
 * 先定义状态，再画出状态转移图，最后编写代码
 */
class Solution {
    public boolean validNumber(String s) {
        // 哈希表是乱序的，需要放在数组里编号
        Map[] states = {
            new HashMap<>() {{ put(' ', 0); put('s', 1); put('d', 2); put('.', 4); }}, // 0.
            new HashMap<>() {{ put('d', 2); put('.', 4); }},                           // 1.
            new HashMap<>() {{ put('d', 2); put('.', 3); put('e', 5); put(' ', 8); }}, // 2.
            new HashMap<>() {{ put('d', 3); put('e', 5); put(' ', 8); }},              // 3.
            new HashMap<>() {{ put('d', 3); }},                                        // 4.
            new HashMap<>() {{ put('s', 6); put('d', 7); }},                           // 5.
            new HashMap<>() {{ put('d', 7); }},                                        // 6.
            new HashMap<>() {{ put('d', 7); put(' ', 8); }},                           // 7.
            new HashMap<>() {{ put(' ', 8); }}                                         // 8.
        };
        int p = 0;
        char t;
        for(char c : s.toCharArray()) {
            if(c >= '0' && c <= '9') t = 'd';
            else if(c == '+' || c == '-') t = 's';
            else if(c == 'e' || c == 'E') t = 'e';
            else if(c == '.' || c == ' ') t = c;
            else return false;
            if(!states[p].containsKey(t)) return false;
            p = (int)states[p].get(t);
        }
        return p == 2 || p == 3 || p == 7 || p == 8;
    }
}