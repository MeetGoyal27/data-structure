/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.offer(root);
        while(q.size()>0){
            TreeNode node = q.poll();
            if(sb.length()>0){
                sb.append(',');
            }
            if(node == null){
                sb.append('n');
            }
            else{
                sb.append(node.val);
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0){
            return null;
        }
        String[] parts = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(parts[0]));
        q.offer(root);
        int i=1;
        while(q.size()>0 && i<parts.length){
            TreeNode parent = q.poll();
            if(i<parts.length && !parts[i].equals("n")){
                TreeNode left = new TreeNode(Integer.parseInt(parts[i]));
                parent.left = left;
                q.offer(left);
            }
            i++;
            if(i<parts.length && !parts[i].equals("n")){
                TreeNode right = new TreeNode(Integer.parseInt(parts[i]));
                parent.right = right;
                q.offer(right);
            }

            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;