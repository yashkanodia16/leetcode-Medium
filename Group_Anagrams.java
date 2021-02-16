// Given an array of strings strs, group the anagrams together. You can return the answer in any order.

// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

// Example 1:

// Input: strs = ["eat","tea","tan","ate","nat","bat"]
// Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
// Example 2:

// Input: strs = [""]
// Output: [[""]]

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        if(strs.length==0)
            return result;
        for(int i=0;i<strs.length;i++){
            String temp = strs[i];
            char[] ch = temp.toCharArray();
            Arrays.sort(ch);
            if(map.containsKey(String.copyValueOf(ch))){
                  map.get(String.copyValueOf(ch)).add(strs[i]);
            }
            else{
                List<String> each = new ArrayList<>();
                each.add(strs[i]);
                map.put(String.copyValueOf(ch),each);
            }
        }
        for(List<String> item: map.values()){
            result.add(item);
        }
        return result;
    }
}
