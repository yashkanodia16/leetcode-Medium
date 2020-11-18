// Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

// Example:

// Input: 

// 1 0 1 0 0
// 1 0 1 1 1
// 1 1 1 1 1
// 1 0 0 1 0

// Output: 4

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int res=0;
        int[][] dp = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(matrix[i-1][j-1]=='1'){
                    dp[i][j] = Math.min(Math.min(dp[i][j-1],dp[i-1][j]),dp[i-1][j-1])+1;
                    res = Math.max(res,dp[i][j]);
                }
            }
        }
        return res*res;
    }
}
