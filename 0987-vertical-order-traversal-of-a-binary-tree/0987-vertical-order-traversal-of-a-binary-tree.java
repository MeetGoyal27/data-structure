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
    public void dfs(TreeNode root,TreeMap<Integer,TreeMap<Integer,List<Integer>>> map,int col,int level){
        if(root == null){
            return;
        }
        if(!map.containsKey(col)){
            map.put(col,new TreeMap<>());
        }
        if(!map.get(col).containsKey(level)){
            map.get(col).put(level,new ArrayList<>());
        }
        map.get(col).get(level).add(root.val);
        dfs(root.left,map,col-1,level+1);
        dfs(root.right,map,col+1,level+1);

    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        TreeMap<Integer,TreeMap<Integer,List<Integer>>> map = new TreeMap<>();
        dfs(root,map,0,0);
        for(Map.Entry<Integer,TreeMap<Integer,List<Integer>>> entry : map.entrySet()){
            TreeMap<Integer,List<Integer>> subMap = entry.getValue();
            List<Integer> list = new ArrayList<>();
            for(Map.Entry<Integer,List<Integer>> subEntry : subMap.entrySet()){
                List<Integer> list1 = subEntry.getValue();
                Collections.sort(list1);
                list.addAll(list1);
            }
            res.add(list);
        }
        return res;

    }
}