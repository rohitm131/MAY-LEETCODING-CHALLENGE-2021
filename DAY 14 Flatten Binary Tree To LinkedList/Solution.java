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
    public void flatten(TreeNode root) {
        
        if(root == null || (root.left == null && root.right == null)) return;
        
        solve(root);
        
    }
    
    private TreeNode solve(TreeNode root) {
        if(root == null) {
            return null;
        }
        
        TreeNode leftChild = solve(root.left);
        TreeNode rightChild = solve(root.right);
        
        TreeNode extremeRightLC = leftChild;
        while(extremeRightLC != null && extremeRightLC.right != null) {
            extremeRightLC = extremeRightLC.right;
        }
        
        if(extremeRightLC != null) {
            extremeRightLC.right = rightChild;
            root.right = leftChild;
        }
        
        root.left = null;
        return root;
        
    }
    
}
