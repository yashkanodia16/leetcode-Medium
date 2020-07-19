// You need to find the largest value in each row of a binary tree.

// Example:
// Input: 

//           1
//          / \
//         3   2
//        / \   \  
//       5   3   9 

// Output: [1, 3, 9]
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> l1 = new ArrayList<>();
        if(root==null)
            return l1;
        int curr=Integer.MIN_VALUE;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
             List<Integer> l2 = new ArrayList<>();
            while(size>0){           
                root = q.poll();
                l2.add(root.val);
                if(root.left!=null)
                    q.add(root.left);
                if(root.right!=null)
                    q.add(root.right);  
                size--;
            }
            Collections.sort(l2);
            l1.add(l2.get(l2.size()-1));
        }
        return l1;
    }
}