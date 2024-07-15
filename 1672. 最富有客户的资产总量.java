class Solution {
    public int maximumWealth(int[][] accounts) {
        int[] sum = new int[accounts.length];
        for (int i=0; i<accounts.length; i++)
            for(int j: accounts[i])
                sum[i] += j;
        int max = sum[0];
        for(int i=1; i<sum.length; i++)
            if(sum[i]>max)
                max = sum[i];
        return max;
    }
}