/* 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。 */

// 手写堆（其实可以用优先队列代替，但是该方法更基础）
class Solution {
    int[] nums;
    int size;

    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        size = nums.length;
        buildMaxHeap();
        // 删除前 k-1 个堆顶，剩下的堆顶就是第 k 大
        for(int i=0; i<k-1; i++){
            popMaxHeap();
        }
        return nums[0];
    }

    // 构造大顶堆
    void buildMaxHeap(){
        for(int i=size/2 - 1; i>=0; i--){
            siftDown(i);
        }
    }

    // 自顶向下堆化
    void siftDown(int i){
        int l=i*2+1, r=i*2+2, max=i;
        if(l<size && nums[l] > nums[max])
            max = l;
        if(r<size && nums[r] > nums[max])
            max = r;
        if(max != i){
            swap(i, max);
            // 因为父子节点做了交换，可能导致子节点有变化
            siftDown(max);
        }
    }

    // 删除堆顶
    void popMaxHeap(){
        swap(0, size-1);
        size--;
        siftDown(0);
    }

    public void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}