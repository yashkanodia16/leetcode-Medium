// Given a non-empty array of integers, return the k most frequent elements.

// Example 1:

// Input: nums = [1,1,1,2,2,3], k = 2
// Output: [1,2]
// Example 2:

// Input: nums = [1], k = 1
// Output: [1]
// Note:

// You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
// Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
// It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
// You can return the answer in any order.

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:nums)
            map.put(i,map.getOrDefault(i,0)+1);
        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>((a,b)->a.getValue()-b.getValue());
        for(Map.Entry<Integer, Integer> curr : map.entrySet()){
            queue.offer(curr);
            if(queue.size()>k)
                queue.poll();
        }
        int[] a = new int[queue.size()];
        int i=0;
        if(queue.size()==0)
            return a;
        while(!queue.isEmpty()){
            a[i]= queue.poll().getKey();
            i++;
        }
       return a;
    }
}