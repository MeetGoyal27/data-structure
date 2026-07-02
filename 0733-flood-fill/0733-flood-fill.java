class Solution {
    public void dfs(int row,int col,int[][] image,boolean[][] vis,int color,int isColor){
        if(row<0 || col<0 || row >= image.length || col >= image[0].length){
            return;
        }
        if(image[row][col] != isColor){
            return;
        }
        if(vis[row][col] == true){
            return;
        }
        vis[row][col] = true;
        image[row][col] = color;
        dfs(row+1,col,image,vis,color,isColor);
        dfs(row-1,col,image,vis,color,isColor);
        dfs(row,col+1,image,vis,color,isColor);
        dfs(row,col-1,image,vis,color,isColor);

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] vis = new boolean[image.length][image[0].length];
        dfs(sr,sc,image,vis,color,image[sr][sc]);
        return image;
    }
}