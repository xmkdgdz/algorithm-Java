/* 题目：
 * 设备中存有 n 个文件，文件 id 记于数组 documents。若文件 id 相同，则定义为该文件存在副本。请返回任一存在副本的文件 id。 
 * ** 0 ≤ documents[i] ≤ n-1 **
 */

// 方法一：哈希表
class Solution {
    public int findRepeatDocument(int[] documents) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int k: documents){
            Integer v = map.get(k);
            if(v == null)   map.put(k, 1);
            else    return k; 
        }
        return -1;
    }
}

// 注意运用条件 0 ≤ documents[i] ≤ n-1

// 方法二：数组
// 时间复杂度O(N), 空间复杂度O(1)
class Solution {
    public int findRepeatDocument(int[] documents) {
        int[] res = new int[documents.length];
        for(int i: documents){
            res[i]++;
            if(res[i] > 1)
                return i;
        }
        return -1;
    }
}

// 方法三：原地交换
// 复杂度一样，但稍快
// 巧妙
class Solution {
    public int findRepeatDocument(int[] documents) {
        int i=0;
        while(i<documents.length){
            if(documents[i] == i)
                i++;
            else if(documents[documents[i]] == documents[i])
                return documents[i];
            else{
                int tmp = documents[i];
                documents[i] = documents[tmp];
                documents[tmp] = tmp;
            }
        }
        return -1;
    }
}