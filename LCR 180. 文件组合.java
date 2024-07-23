/* 
    题目：
    待传输文件被切分成多个部分，按照原排列顺序，每部分文件编号均为一个 正整数（至少含有两个文件）。
    传输要求为：连续文件编号总和为接收方指定数字 target 的所有文件。请返回所有符合该要求的文件传输组合列表。

    注意，返回时需遵循以下规则：
    每种组合按照文件编号 升序 排列；
    不同组合按照第一个文件编号 升序 排列。
    
    示例：
    输入：target = 18
    输出：[[3,4,5,6],[5,6,7]]
*/

// 方法一：暴力解
// 时间复杂度 O(N)，但用时较长
/* 确定左边界 i 和 target 后可以通过求根公式解出右边界 j
 * 所以从小到大一个个尝试 i
 * 如果 j 为整数，且 i<j，则这个符合条件
 * 如果 i>=j，说明已经再也找不到了，因为继续 i++ 只会越来越大 
 */
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] fileCombination(int target) {
        int i = 1;
        double j = 2.0; // 这样计算时才会保留小数
        List<int[]> res = new ArrayList<>();
        while(i < j) {
            j = (-1 + Math.sqrt(1 + 4 * (2 * target + (long) i * i - i))) / 2; // i*i 可能超出 int，需要转换
            if(i < j && j == (int)j) {
                int[] ans = new int[(int)j - i + 1];
                for(int k = i; k <= (int)j; k++)
                    ans[k - i] = k;
                res.add(ans);
            }
            i++;
        }
        return res.toArray(new int[0][]);
    }
}

// 方法二：滑动窗口
class Solution {
    public int[][] fileCombination(int target) {
        int i=1, j=2, sum=3;
        List<int[]> res = new ArrayList<int[]>();
        while(i < j){
            if(sum == target){
                int[] a = new int[j-i+1];
                for(int k=0; k<j-i+1; k++)
                    a[k] = i + k;
                res.add(a);
            }
            if(sum >= target){ // 等于时也要把左边界滑动一个，以找到更多解
                sum -= i;
                i++;
            }
            else if(sum < target){
                j++;
                sum += j;
            }
        }
        return res.toArray(new int[0][]);
    }
}

// 方法三：遍历n
// 速度最快
class Solution {
    public int[][] fileCombination(int target) {
        List<int[]> res = new ArrayList<int[]>();
        int max = (int)Math.sqrt(2*target); // 经过数学计算 n < sqrt(2t)
        // 循环遍历可能的序列长度
        for(double n=(double)max; n>1; n--){
            double a = target/n - n/2 + 1.0/2; // 计算出 a1
            if(a == (int)a){
                int[] ans = new int[(int)n];
                for(int j = 0; j < (int)n; j++)
                    ans[j] = (int)a+j;
                res.add(ans);
            }
        }
        return res.toArray(new int[0][]);
    }
}