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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null){
            return list;
        }
        q.offer(root);
        while(q.size()>0){
            int level = q.size();
            List<Integer> li = new ArrayList<>();
            for(int i=0;i<level;i++){
            TreeNode element = q.poll();
            li.add(element.val);
            if(element.left != null){
                q.offer(element.left);
            }
            if(element.right != null){
                q.offer(element.right);
            }
            }
            list.add(0,li);
        }
        return list;
        
    }
}