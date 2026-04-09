class Solution {
    public boolean fun(char[][] board,int row,int col,String word,int idx){
        int m = board.length;
        int n = board[0].length;
        if(idx == word.length()){
            return true;
        }
        if(row < 0 || col < 0 || row == m || col == n){
            return false;
        }
        if(board[row][col] != word.charAt(idx)){
            return false;
        }
        if(board[row][col] == '.'){
            return false;
        }
        char ch = board[row][col];
        board[row][col] = '.';
        if(fun(board,row+1,col,word,idx+1) || fun(board,row,col+1,word,idx+1) || fun(board,row-1,col,word,idx+1) || fun(board,row,col-1,word,idx+1)){
            return true;
        }
        board[row][col] = ch;
        return false;
    }
    public boolean exist(char[][] board, String word){
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == word.charAt(0)){
                    if(fun(board,i,j,word,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}