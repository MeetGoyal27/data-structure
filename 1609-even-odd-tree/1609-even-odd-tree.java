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
    public boolean isEvenOddTree(TreeNode root) {
        if(root == null){
            return false;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;
        while(q.size()>0){
            int size = q.size();
            int prev = (level%2==0)?Integer.MIN_VALUE:Integer.MAX_VALUE;
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                int val = node.val;
                if(level%2 == 0){
                    if(val%2==0 || val <= prev){
                        return false;
                    }
                }
                else{
                    if(val%2==1 || val >= prev){
                        return false;
                    }
                }
                prev = val;
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
            level++;
        }
        return true;
    }
}