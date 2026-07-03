class Solution {
    public void helper(int row,int col,int[][] image,boolean[][] vis,int color,int isColor){
        if(row<0 || col<0 || row>=image.length || col >= image[0].length){
            return;
        }
        if(vis[row][col] == true){
            return;
        }
        if(image[row][col] != isColor){
            return;
        }
        vis[row][col] = true;
        image[row][col] = color;
        helper(row+1,col,image,vis,color,isColor);
        helper(row-1,col,image,vis,color,isColor);
        helper(row,col+1,image,vis,color,isColor);
        helper(row,col-1,image,vis,color,isColor);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] vis = new boolean[image.length][image[0].length];
        helper(sr,sc,image,vis,color,image[sr][sc]);
        return image;
    }
}