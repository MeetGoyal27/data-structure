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
    public TreeNode helper(int[] preorder,HashMap<Integer,Integer> map,int rootIdx,int start,int end){
        TreeNode root = new TreeNode(preorder[rootIdx]);
        int mid = map.get(preorder[rootIdx]);
        if(mid > start){
            root.left = helper(preorder,map,rootIdx+1,start,mid-1);
        }
        if(mid < end){
            root.right = helper(preorder,map,rootIdx+mid-start+1,mid+1,end);
        }
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(preorder,map,0,0,inorder.length-1);
    }
}