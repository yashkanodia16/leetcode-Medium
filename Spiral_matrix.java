// Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

// Example 1:

// Input:
// [
//  [ 1, 2, 3 ],
//  [ 4, 5, 6 ],
//  [ 7, 8, 9 ]
// ]
// Output: [1,2,3,6,9,8,7,4,5]
// Example 2:

// Input:
// [
//   [1, 2, 3, 4],
//   [5, 6, 7, 8],
//   [9,10,11,12]
// ]
// Output: [1,2,3,4,8,12,11,10,9,5,6,7]

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> l1 = new ArrayList<>();
        if(matrix.length==0)
            return l1;
        int m = matrix.length-1, n = matrix[0].length-1;
        int left = 0, right = n, top =0, bottom = m, dir=0;
        while(top<=bottom && left<=right){
            if(dir ==0 ){
                for(int i=left;i<=right;i++)
                    l1.add(matrix[top][i]);
                top++;
                dir=1;
            }
             else if(dir ==1 ){
                for(int i=top;i<=bottom;i++)
                    l1.add(matrix[i][right]);
                right--;
                dir=2;
            }
             else if(dir ==2 ){
                for(int i=right;i>=left;i--)
                    l1.add(matrix[bottom][i]);
                bottom--;
                dir=3;
            }
              else if(dir ==3 ){
                for(int i=bottom;i>=top;i--)
                    l1.add(matrix[i][left]);
                left++;
                dir=0;
            }
        }
        return l1;
    }
}