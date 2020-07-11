// Given a set of distinct integers, nums, return all possible subsets (the power set).

// Note: The solution set must not contain duplicate subsets.

// Example:

// Input: nums = [1,2,3]
// Output:
// [
//   [3],
//   [1],
//   [2],
//   [1,2,3],
//   [1,3],
//   [2,3],
//   [1,2],
//   []
// ]

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> l1 = new ArrayList<>();
        backtrack(l1,nums,new ArrayList<>(),0);
        return l1;
    }
    public void backtrack(List<List<Integer>> l1,int[] nums,List<Integer> l2,int start){
        l1.add(new ArrayList<>(l2));
        for(int i=start;i<nums.length;i++){
            l2.add(nums[i]);
            backtrack(l1,nums,l2,i+1);
            l2.remove(l2.size()-1);
        }
    }
}
