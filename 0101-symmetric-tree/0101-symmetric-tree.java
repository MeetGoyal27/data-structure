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
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(root.left);
        q2.offer(root.right);
        while(q1.size()>0 && q2.size()>0){
            TreeNode n1 = q1.poll();
            TreeNode n2 = q2.poll();
            if(n1 == null && n2 == null){
                continue;
            }
            if(n1 == null || n2 == null){
                return false;
            }
            if(n1.val != n2.val){
                return false;
            }
            q1.offer(n1.left);
            q1.offer(n1.right);
            q2.offer(n2.right);
            q2.offer(n2.left);
        } 
        return true;
    }
}