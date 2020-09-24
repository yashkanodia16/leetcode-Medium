class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<words.length;i++){
            if(map.containsKey(words[i]))
                map.put(words[i],map.get(words[i])+1);
            else 
                map.put(words[i],1);
        }
        List<String> l1 = new ArrayList<>();
         PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                 (a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue()
        );
        for(Map.Entry<String,Integer> mp: map.entrySet()){
            pq.offer(mp);
            if(pq.size()>k)
                pq.poll();
        }
        while(pq.size()!=0)
            l1.add(0,pq.poll().getKey());
        return l1;
    }
}
