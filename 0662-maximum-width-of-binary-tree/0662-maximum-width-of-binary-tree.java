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
    class CustomNode{
        TreeNode node;
        int idx;
        CustomNode(TreeNode node,int idx){
            this.node = node;
            this.idx = idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Deque<CustomNode> q = new LinkedList<>();
        q.offer(new CustomNode(root,0));
        int max = Integer.MIN_VALUE;
        while(q.size()>0){
            int size = q.size();
            int fidx = q.getFirst().idx;
            int lidx = q.getLast().idx;
            max = Math.max(max,lidx-fidx+1);
            for(int i=0;i<size;i++){
                CustomNode cnode = q.poll();
                TreeNode tnode = cnode.node;
                int iidx = cnode.idx;
                if(tnode.left != null){
                    q.offer(new CustomNode(tnode.left,(2*iidx)+1));
                }
                if(tnode.right != null){
                    q.offer(new CustomNode(tnode.right,(2*iidx)+2));
                }
            }
        }
        return max;
    }
}