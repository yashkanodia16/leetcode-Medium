class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<=1)
            return s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        int start=0,end=0;
        int max =0;
        for(end =0;end<s.length();end++){
            if(map.containsKey(s.charAt(end))){
                start = Math.max(start,map.get(s.charAt(end))+1);
            }
            max = Math.max(max,end-start+1);
            map.put(s.charAt(end),end);
        }
        return max;
    }
}
