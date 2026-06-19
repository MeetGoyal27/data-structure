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
    public int findHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = findHeight(root.left);
        int right = findHeight(root.right);
        return Math.max(left,right)+1;
    }
    public int findBottomLeftValue(TreeNode root) {
        int height = findHeight(root);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int count = 1;
        while(q.size()>0){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                if((count == height) && (i == 0)){
                    return node.val;
                }
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
            count++;
        }
        return root.val;
    }
}