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
    public void preOrder(TreeNode root,Queue<TreeNode> q){
        if(root == null){
            return;
        }
        q.offer(root);
        preOrder(root.left,q);
        preOrder(root.right,q);
    }
    public void flatten(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        preOrder(root,q);
        while(q.size()>0){
            TreeNode node = q.poll();
            node.left = null;
            node.right = q.peek();
        }
    }
}