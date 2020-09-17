class Solution {
    int maxGold = 0;
    public int getMaximumGold(int[][] grid) {
        int m = grid.length, n = grid[0].length;    
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=0)
                    dfs(grid, i,j,0);
            }
        }
        return maxGold;
    }
    private void dfs(int[][] grid, int i, int j,int curr){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0){
            maxGold = Math.max(maxGold,curr);
            return;
        }
        int val = grid[i][j];
        grid[i][j] = 0;
        dfs(grid,i+1,j,curr+val);
        dfs(grid,i-1,j,curr+val);
        dfs(grid,i,j+1,curr+val);
        dfs(grid,i,j-1,curr+val);
        grid[i][j] = val;
    }    
}



