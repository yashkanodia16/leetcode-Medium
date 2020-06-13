// Given an unsorted array of integers, find the length of longest increasing subsequence.

// Example:

// Input: [10,9,2,5,3,7,101,18]
// Output: 4 
// Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
// Note:

// There may be more than one LIS combination, it is only necessary for you to return the length.
// Your algorithm should run in O(n2) complexity.

class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length <= 1) 
			return nums.length;
        int t[] = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            t[i]=1;
        }
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    if(t[j]+1>t[i])
                        t[i] = t[j] + 1;
                }
            }
        }
        int longest =0;
        for(int i=0;i<t.length;i++)
             longest = Math.max(longest,t[i]);
        return longest;
    }
}