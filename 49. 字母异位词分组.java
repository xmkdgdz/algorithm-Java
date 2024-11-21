/* 给你一个字符串数组，请你将 字母异位词 组合在一起。
可以按任意顺序返回结果列表。
字母异位词：是由重新排列源单词的所有字母得到的一个新单词。

示例 1:
输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */

// 哈希

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// 方法一：排序后的字符串作为键
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new LinkedList<>();
        // 建立哈希表：键为排序后的字符串，值为该字符串的所有字母异位词
        Map<String, List<String>> map = new HashMap<>();

        for(String s: strs){
            // 对原字符排序
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String s2 = new String(chars);
            // 如果存在，则作为一个异位词加入；不存在，则新建
            List<String> list = map.getOrDefault(s2, new LinkedList<String>());
            list.add(s);
            map.put(s2, list);
        }
        // 存入结果
        for(List<String> lst: map.values()){
            res.add(lst);
        }
        return res;
    }
}

// 方法二：计数
/* 异位词的字母出现次数相同，将 出现过的字母 和 次数 拼接成字符串 作为键 */