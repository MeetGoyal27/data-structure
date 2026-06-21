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
    int ans = Integer.MIN_VALUE;
    public int calculate(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = Math.max(calculate(root.left),0);
        int right = Math.max(calculate(root.right),0);
        ans = Math.max(ans,root.val+left+right);
        return root.val + Math.max(left,right);
    }
    public int maxPathSum(TreeNode root) {
        calculate(root);
        return ans;
    }
}