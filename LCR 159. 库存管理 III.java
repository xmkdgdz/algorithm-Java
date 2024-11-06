/* 题目：返回数组 stock 中最小的 cnt 个数，返回顺序不限 */

// 方法一：优先队列
class Solution {
    public int[] inventoryManagement(int[] stock, int cnt) {
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        int[] res = new int[cnt];
        for(int i=0; i<stock.length; i++)
            priorityQueue.offer(stock[i]);
        for(int i=0; i<cnt; i++)
            res[i] = priorityQueue.poll();
        return res;
    }
}

// 方法二：排序
class Solution {
    public int[] inventoryManagement(int[] stock, int cnt) {
        int[] vec = new int[cnt];
        stockays.sort(stock);
        for (int i = 0; i < cnt; ++i) {
            vec[i] = stock[i];
        }
        return vec;
    }
}

// 方法三：快速选择
/* 利用快排，但是不需要全部排列 */
class Solution {
    int[] stock;
    int cnt;

    public int[] inventoryManagement(int[] stock, int cnt) {
        this.stock = stock;
        this.cnt = cnt;
        quicksort(0, stock.length-1);
        return Arrays.copyOf(stock, cnt);
    }

    void quicksort(int l, int r){
        if(l>=r) return;
        int i=l, j=r;
        while(i<j){
            while(i<j && stock[j]>=stock[l]) j--;
            while(i<j && stock[i]<=stock[l]) i++;
            swap(i, j);
        }
        swap(l, i);
        // 排序后 基准i 左边 < i < 右边
        // i<cnt，cnt还包括右边部分，需要对 [i+1, r] 继续排列
        if(i<cnt) quicksort(i+1, r);
        // i<cnt，cnt没有包括全部左边部分，需要对 [l,i-1] 继续排列
        else if(i>cnt) quicksort(l, i-1);
        // i==cnt 左边就全部都是结果了
        return;
    }

    void swap(int i, int j) {
        int tmp = stock[i];
        stock[i] = stock[j];
        stock[j] = tmp;
    }
}