// Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

// Example:

// Input: 3
// Output:
// [
//  [ 1, 2, 3 ],
//  [ 8, 9, 4 ],
//  [ 7, 6, 5 ]
// ]

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if(n==0)
            return matrix;
        int num = 1; 
        int m = matrix.length-1, n1 = matrix[0].length-1;
        int left = 0, right = n1, top =0, bottom = m, dir=0;
        while(top<=bottom && left<=right){
            if(dir ==0 ){
                for(int i=left;i<=right;i++)
                    matrix[top][i]=num++;
                top++;
                dir=1;
            }
             else if(dir ==1 ){
                for(int i=top;i<=bottom;i++)
                    matrix[i][right]=num++;
                right--;
                dir=2;
            }
             else if(dir ==2 ){
                for(int i=right;i>=left;i--)
                    matrix[bottom][i]=num++;
                bottom--;
                dir=3;
            }
              else if(dir ==3 ){
                for(int i=bottom;i>=top;i--)
                    matrix[i][left]=num++;
                left++;
                dir=0;
            }
        }
        return matrix;
    }
}