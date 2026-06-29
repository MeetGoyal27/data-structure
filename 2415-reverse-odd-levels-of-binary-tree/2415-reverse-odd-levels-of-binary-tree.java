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
    public TreeNode reverseOddLevels(TreeNode root) {
        int level = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(q.size()>0){
            int size = q.size();
            List<TreeNode> list = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                list.add(node);
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
            if(level % 2 == 1){
                int start = 0;
                int end = list.size()-1;
                while(start<end){
                    int temp = list.get(start).val;
                    list.get(start).val = list.get(end).val;
                    list.get(end).val = temp;
                    start++;
                    end--;
                }
            }
            level++;
        }
        return root;
    }
}