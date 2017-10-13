class Solution {
    public boolean visited[][];
    public boolean exist(char[][] board, String word) {
        if(word.length() == 0) return true;
        int rows = board.length;
        int cols = board[0].length;
        visited = new boolean[rows][cols];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols;j++){
                if(searchWord(board, word, 0, i, j)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean searchWord(char[][] board, String word, int n, int x, int y){
        //base case
        if(n==word.length()){
            return true;
        }
        //check bounds
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length){
            return false;
        }
        //check visited
        if(visited[x][y]){
            return false;
        }
        //check for character match
        if(board[x][y] != word.charAt(n)){
            return false;
        }
        visited[x][y]=true;
        boolean result = searchWord(board, word, n+1, x-1, y) || searchWord(board, word, n+1, x, y-1) ||
                searchWord(board, word, n+1, x+1, y) || searchWord(board, word, n+1, x, y+1);
        visited[x][y]=false;
        return result;
    }
}
