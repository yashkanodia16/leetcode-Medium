// Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.

// Example 1:

// Input:
// A: [1,2,3,2,1]
// B: [3,2,1,4,7]
// Output: 3
// Explanation: 
// The repeated subarray with maximum length is [3, 2, 1].
 

// Note:

// 1 <= len(A), len(B) <= 1000
// 0 <= A[i], B[i] < 100

class Solution {
    public int findLength(int[] A, int[] B) {
        int m= A.length;
        int n= B.length;
        int ans =0;
        int t[][] = new int[m+1][n+1];
        if(m == 0 || n == 0)
            return 0;
       for(int i=m-1;i>=0;i--){
           for(int j=n-1;j>=0;j--){
               if(A[i]==B[j])
                   t[i][j] = t[i+1][j+1] + 1;
               if(ans < t[i][j])
                   ans = t[i][j];
          }
       }
        return ans;
    }
}