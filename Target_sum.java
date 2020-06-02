// You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

// Find out how many ways to assign symbols to make sum of integers equal to target S.

// Example 1:
// Input: nums is [1, 1, 1, 1, 1], S is 3. 
// Output: 5
// Explanation: 

// -1+1+1+1+1 = 3
// +1-1+1+1+1 = 3
// +1+1-1+1+1 = 3
// +1+1+1-1+1 = 3
// +1+1+1+1-1 = 3

// There are 5 ways to assign symbols to make the sum of nums be target 3.
// Note:
// The length of the given array is positive and will not exceed 20.
// The sum of elements in the given array will not exceed 1000.
// Your output answer is guaranteed to be fitted in a 32-bit integer.


class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum =0;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(nums[i]==0)
                count += 1;
        }
        if(S > sum)
            return 0;
        if((S + sum)%2 != 0)
            return 0;
        int target = 0;
        target = (S + sum)/2;
        int t[][] = new int[nums.length+1][target+1];
        for(int i=0;i<=nums.length;i++)
            t[i][0]=1;
        for(int i=1;i<=nums.length;i++){
            for(int j=1; j<=target;j++){
                  if(nums[i-1]==0)
                    t[i][j] = t[i-1][j];
                else if(j < nums[i-1])
                    t[i][j] = t[i-1][j];
                else
                    t[i][j] = t[i-1][j] + t[i-1][j-nums[i-1]];
            }
        }
        double res1 = Math.pow(2,count);
        double res2 = t[nums.length][target];
        return (int)(res1*res2);
    }
}