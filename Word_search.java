// Given an m x n board and a word, find if the word exists in the grid.

// The word can be constructed from letters of sequentially adjacent cells, where "adjacent" cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

// Example 1:


// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
// Output: true
// Example 2:


// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
// Output: true
// Example 3:


// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
// Output: false
 

// Constraints:

// m == board.length
// n = board[i].length
// 1 <= m, n <= 200
// 1 <= word.length <= 103
// board and word consists only of lowercase and uppercase English letters.

class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] used = new boolean[board.length][board[0].length];
        if(board == null || word == null)
            return false;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(dfs(board,word,i,j,0,used))
                    return true;
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, int i, int j, int count,boolean[][] used){
        if(count == word.length())
            return true;
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || word.charAt(count)!=board[i][j] || used[i][j]!=false)
            return false;
        if(board[i][j]==word.charAt(count)){
            used[i][j] = true;
            if(dfs(board,word,i+1,j,count+1, used) || dfs(board,word,i-1,j,count+1,used) || dfs(board,word,i,j+1,count+1,used) || dfs(board,word,i,j-1,count+1,used))
                return true;
            used[i][j] = false;
        } 
        return false;
    }
}
