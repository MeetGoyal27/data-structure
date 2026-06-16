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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;
        while(q.size()>0){
            if(level %2 == 0){
                int size = q.size();
                List<Integer> l1 = new ArrayList<>();
                for(int i=0;i<size;i++){
                    TreeNode node = q.poll();
                    l1.add(node.val);
                    if(node.left != null){
                        q.offer(node.left);
                    }
                    if(node.right != null){
                        q.offer(node.right);
                    }
                }
                list.add(l1);
                level++;
            }
            else{
                int size = q.size();
                List<Integer> l1 = new ArrayList<>();
                for(int i=0;i<size;i++){
                    TreeNode node = q.poll();
                    l1.add(node.val);
                    if(node.left != null){
                        q.offer(node.left);
                    }
                    if(node.right != null){
                        q.offer(node.right);
                    }
                }
                Collections.reverse(l1);
                list.add(l1);
                level++;
            }
        }
        return list;
    }
}