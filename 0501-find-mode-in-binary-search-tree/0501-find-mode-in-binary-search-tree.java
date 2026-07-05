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
    HashMap<Integer,Integer> map = new HashMap<>();
    public void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        map.put(root.val,map.getOrDefault(root.val,0)+1);
        inorder(root.right);
    }
    public int[] findMode(TreeNode root) {
        inorder(root);
        int max = 0;
        for(int x : map.values()){
            max = Math.max(max,x);
        }
        List<Integer>list = new ArrayList<>();
        for(int i : map.keySet()){
            if(map.get(i) == max){
                list.add(i);
            }
        }
        int ans[] = new int [list.size()];
        int i=0;
        for(int n:list){
            ans[i++]=n;
        }
        return ans;


    }
}