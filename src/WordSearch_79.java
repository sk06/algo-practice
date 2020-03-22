/*
 * Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
 */
public class WordSearch_79 {
	int opts[][] = {{-1,0},{1,0},{0,-1},{0,1}};
    public boolean exist(char[][] board, String word) {
        if (word.isEmpty()) return false;
        if (board.length == 0) return false;
        for (int i = 0; i< board.length ; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == word.charAt(0)){
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    if (exist(board, visited, word, i, j, 0)) return true;
                }
            }
        }  
        return false;
    }
    
    public boolean exist(char[][] board, boolean[][] visited, String word, int i, int j, int idx) {
        // is valid ?
        boolean isValid = isValid(board, visited, word, i, j, idx);
        if (!isValid) return false;
        // is solution ?
        if (idx == word.length() - 1) return true;

        visited[i][j] = true;
        boolean exists = false;
        //try all options and back track each one
        for (int[] opt : opts){
            int next_i = i+opt[0];
            int next_j = j+opt[1];
            exists = exists || exist(board, visited, word, next_i, next_j, idx+1);
        }
        visited[i][j] = false;
        return exists;
    }
    
    public boolean isValid(char[][] board, boolean[][] visited, String word, int i, int j, int idx) {
            
        if ((i < 0 || i >= board.length) ||
            (j < 0 || j >= board[0].length) ||
            visited[i][j] || 
            idx >= word.length() || 
            board[i][j] != word.charAt(idx) ) {
            return false;
        }
                
        return true;
    }

}
