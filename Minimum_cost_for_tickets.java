class Solution {
    Integer[] dp;
    public int mincostTickets(int[] days, int[] costs) {
         dp = new Integer[days.length];
        return helper(days, costs, 0);
    }
    
    private int helper(int[] days, int[] costs, int day) {
        if(day >= days.length)
            return 0;
    
        if(dp[day] != null)
            return dp[day];
        
        int ondDayPass = helper(days, costs, day + 1) + costs[0];
        
        int i;
        for(i = day; i < days.length; i++)
            if(days[i] >= days[day] + 7)
                break;
        
        int sevenDayPass = helper(days, costs, i) + costs[1];
        
        for(i = day; i < days.length; i++)
            if(days[i] >= days[day] + 30)
                break;
        
        int thirtyDayPass = helper(days, costs, i) + costs[2];
        
        return dp[day] = Math.min(ondDayPass, Math.min(sevenDayPass, thirtyDayPass));
    }
}