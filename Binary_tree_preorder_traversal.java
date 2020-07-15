// Given a binary tree, return the preorder traversal of its nodes' values.

// Example:

// Input: [1,null,2,3]
//    1
//     \
//      2
//     /
//    3

// Output: [1,2,3]
// Follow up: Recursive solution is trivial, could you do it iteratively?

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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> l1 = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = new TreeNode();
        curr = root;
        while(!stack.isEmpty() || curr!=null){
            while(curr!=null){
                stack.push(curr);
                l1.add(curr.val);
                curr = curr.left;
            }
            curr = stack.pop();
            curr = curr.right;
        }
        return l1;
    }
}