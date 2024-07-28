/* 
    给你一个字符串 s ，请你反转字符串中 单词 的顺序。
    单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
    返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
    注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
    
    示例 1：
    输入：s = "the sky is blue"
    输出："blue is sky the"
 */

//  方法一：栈

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public String reverseMessage(String message) {
        Deque<String> stack = new LinkedList<>();
        StringBuilder word = new StringBuilder();
        for(char c: message.toCharArray()){
            if(c != ' '){
                word.append(c);
            }
            else if(c == ' ' && !word.toString().isEmpty()){
                stack.push(word.toString());
                word.setLength(0);
            }
        }
        if(!word.toString().isEmpty())
            stack.push(word.toString());

        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            res.append(stack.pop()+" ");
        }
        if(res.isEmpty()) return "";
        res.deleteCharAt(res.length()-1);
        return res.toString();
    }
}

// 方法二：使用内置函数
class Solution {
    public String reverseWords(String s) {
        // 去除首尾空格
        s = s.trim();
        // 以空格（无论数量）分隔
        List<String> words = Arrays.asList(s.split("\\s+"));
        // 反转列表
        Collections.reverse(words);

        return String.join(" ", words);
    }
}

// 方法三：双指针
/* 倒序遍历字符串 s，记录单词左右索引边界 i, j
 * 每确定一个单词的边界，则将其添加至单词列表 res
 * 最终，将单词列表拼接为字符串，并返回即可。
 */
class Solution {
    public String reverseWords(String s) {
        // 源字符数组
        char[] initialArr = s.toCharArray();

        StringBuilder res = new StringBuilder();

        // 对源字符数组从后往前遍历
        int i = initialArr.length - 1;
        while (i >= 0) {
            // 跳过空格
            while (i >= 0 && initialArr[i] == ' ') {
                i--;  
            }
            // 到达右边界
            int right = i;
            // 确定左边界
            while (i >= 0 && initialArr[i] != ' ') {
                i--; 
            }
            if(right >= 0){
                int left = i+1;
                res.append(s.substring(left, right+1) + " ");
            }
        }
        
        if(res.isEmpty()) return "";
        res.deleteCharAt(res.length()-1);
        return res.toString();
    }
}

// 完全不用 StringBuilder 更快