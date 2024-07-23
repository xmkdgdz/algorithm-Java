/*  
    题目：
    数组 arrayA ，其中 arrayA[i] 表示第 i 个生物群体的数量。
    请返回一个数组 arrayB
    其中 arrayB[i] 表示将第 i 个生物群体的数量从总体中排除后的其他数量的乘积。
 */

// 方法一：算出全部的积后每个再除
// 注意 0 的特殊情况
class Solution {
    public int[] statisticalResult(int[] arrayA) {
        int n =arrayA.length;
        int[] arrayB = new int[n];
        int sum = 1; // 不含 0 的积
        int zero = 0;
        for(int i: arrayA){
            if(i == 0) zero++;
            else sum *= i;
        }
        for(int i=0; i<n; i++){
            if(zero == 0)
                arrayB[i] = sum/arrayA[i];
            else if(zero == 1 && arrayA[i] == 0)
                arrayB[i] = sum;
            else
                arrayB[i] = 0;
        }
        return arrayB;
    }
}

// 方法二：只乘
/* 
    解析：https://leetcode.cn/leetbook/read/illustration-of-algorithm/lhiayd/

    举例: [1,2,3,4,5]
    B[i] = A[0] * ...*A[n] （除了A[i]=1）
    如下，B[i] = 第 i 行的积
        A[0] A[1] ...
    B[0]  1   2   3   4   5
    B[1]  1   1   3   4   5
    ...   1   2   1   4   5
    ...   1   2   3   1   5
    ...   1   2   3   4   1

    分为上三角和下三角两部分
    先求上三角（左边的），再求下三角（右边的
 */
class Solution {
    public int[] statisticalResult(int[] arrayA) {
        int n =arrayA.length;
        int[] arrayB = new int[n];
        if(n == 0) return arrayB;
        arrayB[0] = 1;
        for(int i=1; i<n; i++)
            arrayB[i] = arrayB[i-1] * arrayA[i-1];
        int tmp = 1; // 需要额外存储右边之积，不能用B存了
        for(int i=n-2; i>=0; i--){
            tmp *= arrayA[i+1];
            arrayB[i] *= tmp;            
        }
        return arrayB;
    }
}