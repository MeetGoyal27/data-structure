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
    int postIdx;
    public TreeNode helper(int[] postorder,HashMap<Integer,Integer> map,int start,int end){
        if(start>end){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postIdx]);
        postIdx--;
        int mid = map.get(root.val);
        root.right = helper(postorder,map,mid+1,end);
        root.left = helper(postorder,map,start,mid-1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        postIdx = postorder.length-1;
        return helper(postorder,map,0,inorder.length-1);
    }
}