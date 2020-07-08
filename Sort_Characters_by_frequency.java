// Given a string, sort it in decreasing order based on the frequency of characters.

// Example 1:

// Input:
// "tree"

// Output:
// "eert"

// Explanation:
// 'e' appears twice while 'r' and 't' both appear once.
// So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
// Example 2:

// Input:
// "cccaaa"

// Output:
// "cccaaa"

// Explanation:
// Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
// Note that "cacaca" is incorrect, as the same characters must be together.
// Example 3:

// Input:
// "Aabb"

// Output:
// "bbAa"

// Explanation:
// "bbaA" is also a valid answer, but "Aabb" is incorrect.
// Note that 'A' and 'a' are treated as two different characters.

class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i)))
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            else
                map.put(s.charAt(i),1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> queue = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        for(Map.Entry<Character,Integer> nums: map.entrySet()){
               queue.offer(nums);
        }
        StringBuilder str = new StringBuilder();
        while(!queue.isEmpty()){
            Map.Entry<Character,Integer> temp = queue.poll();
            int count = temp.getValue();
            while(count!=0){
                str.append(temp.getKey());
                count--;
            }
        }
        return str.toString();
    }
}