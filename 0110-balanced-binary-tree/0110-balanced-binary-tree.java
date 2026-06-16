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
    public int calculate(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = calculate(root.left);
        int right = calculate(root.right);
        int balanced = Math.abs(left-right);
        if(balanced > 1){
            return -1;
        }
        if(left == -1 || right == -1){
            return -1;
        }
        return Math.max(left,right)+1;
    }
    public boolean isBalanced(TreeNode root) {
        int ans = calculate(root);
        if(ans == -1){
            return false;
        }
        return true;
    }
}