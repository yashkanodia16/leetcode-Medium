// Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

// Note:

// Each of the array element will not exceed 100.
// The array size will not exceed 200.
 

// Example 1:

// Input: [1, 5, 11, 5]

// Output: true

// Explanation: The array can be partitioned as [1, 5, 5] and [11].
 

// Example 2:

// Input: [1, 2, 3, 5]

// Output: false

// Explanation: The array cannot be partitioned into equal sum subsets.

class Solution {
    public boolean canPartition(int[] nums) {
       int sum =0;
        int i=0;
        int j=0;
        for(i=0;i<nums.length;i++)
           sum += nums[i];
        if(sum % 2 != 0)
            return false;
        sum = sum/2;
        boolean t[][] = new boolean[nums.length+1][sum+1];
        for( i=0;i <=nums.length;i++){
            t[i][0]=true;
            }
         for( i=1;i <=nums.length;i++){
            for(j=1; j <= sum; j++ ){
                if(nums[i-1]<=j)
                    t[i][j] = (t[i-1][j-nums[i-1]]) || (t[i-1][j]);
                else
                    t[i][j] = t[i-1][j];
            }
         }
        
        return t[nums.length][sum];
    }
}