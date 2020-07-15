// Given a binary tree, return the inorder traversal of its nodes' values.

// Example:

// Input: [1,null,2,3]
//    1
//     \
//      2
//     /
//    3

// Output: [1,3,2]
// Follow up: Recursive solution is trivial, could you do it iteratively?

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> l1 = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
      Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = new TreeNode();
        curr = root;
        while(!stack.isEmpty() || curr!=null){
            while(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
            curr=stack.pop();
            l1.add(curr.val);
            curr = curr.right;
        }
        return l1;
    } 
}