/* 在股票交易中，如果前一天的股价高于后一天的股价，则可以认为存在一个「交易逆序对」。
请设计一个程序，输入一段时间内的股票交易记录 record，返回其中存在的「交易逆序对」总数。
示例 1:
输入：record = [9, 7, 5, 4, 6]
输出：8
解释：交易中的逆序对为 (9, 7), (9, 5), (9, 4), (9, 6), (7, 5), (7, 4), (7, 6), (5, 4)。
 */

// 易想到循环遍历数组的暴力解法，但时间复杂度 O(N^2) 较大

// 归并排序
// 本质是在合并过程中记录res
class Solution {
    int res = 0;
    int[] record;

    public int reversePairs(int[] record) {
        this.record = record;
        mergeSort(0, record.length-1);
        return res;
    }

    void mergeSort(int l, int r){
        if(l >= r) return;
        int m = (r-l)/2 + l;
        mergeSort(l, m);
        mergeSort(m+1, r);
        // 虽然只返回 res，但依旧需要排序，这样才能确保每小部分有序，不重不漏
        // 需要tmp数组辅助排序
        int[] tmp = new int[r-l+1];
        int i=l, j=m+1, k=0;
        while(i<=m && j<=r){
            // 在归并的合并过程中，左与右的相对位置不会改变
            // 所以 i>j，则左边i之后的每一个都大于j
            if(record[i] > record[j]){
                res += m-i+1;
                tmp[k++] = record[j++];
            }else{
                tmp[k++] = record[i++];
            }
        }
        while(i<=m) tmp[k++] = record[i++];
        while(j<=r) tmp[k++] = record[j++];
        for(k=0; k<tmp.length; k++){
            record[l+k] = tmp[k];
        }
        return;
    }
}