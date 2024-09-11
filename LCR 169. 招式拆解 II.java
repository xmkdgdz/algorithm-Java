/* 某套连招动作记作仅由小写字母组成的序列 arr，其中 arr[i] 第 i 个招式的名字。
请返回第一个只出现一次的招式名称，如不存在请返回空格。 */

// 方法一：有序哈希表
class Solution {
    public char dismantlingAction(String arr) {
        Map<Character, Boolean> map = new LinkedHashMap<>();
        char[] chars = arr.toCharArray();
        for(Character i: chars){
            map.put(i, map.containsKey(i));
        }
        for(Map.Entry<Character, Boolean> kv: map.entrySet()){
            if(!kv.getValue()) return kv.getKey();
        }
        return ' ';
    }
}

// 方法二：数组
class Solution {
    public char dismantlingAction(String arr) {
        int[] res = new int[26];
        // 记录每个字母出现的次数
        for(char ch: arr.toCharArray()){
            res[ch-'a']++;
        }
        // 找到 str 中第一个出现次数为1的
        for(char ch: arr.toCharArray()){
            if(res[ch-'a'] == 1) return ch;
        }
        return ' ';
    }
}