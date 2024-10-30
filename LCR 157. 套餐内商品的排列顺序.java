/* 某店铺将用于组成套餐的商品记作字符串 goods，
其中 goods[i] 表示对应商品。请返回该套餐内所含商品的 全部排列方式 。
返回结果 无顺序要求，但不能含有重复的元素。 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Solution {
    List<String> res = new LinkedList<>();
    char[] arr;

    public String[] goodsOrder(String goods) {
        arr = goods.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    void dfs(int x){
        if(x == arr.length){
            res.add(new String(arr));
            return;
        }
        Set<Character> set = new HashSet<>();
        for(int i=x; i<arr.length; i++){
            if(set.contains(arr[i])) continue;
            set.add(arr[i]);
            swap(x, i);
            dfs(x+1);
            swap(x, i);
        }
    }

    void swap(int a, int b){
        char tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}