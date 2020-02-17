/*
 * @lc app=leetcode id=289 lang=java
 *
 * [289] Game of Life
 */

// @lc code=start
class Solution {
    private static final int[][] directions = {{1,1},{1,0},{1,-1},{-1,-1},{-1,0},{-1,1},{0,1},{0,-1}};
    public void gameOfLife(int[][] board) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                int counts = countNeighbors(board,r,c);
                if (board[r][c] == 1) {
                    if (counts < 2) board[r][c] = 2; //2 for was alive but will dead
                    else if (counts > 3) board[r][c] = 2;
                }
                else {
                    if (counts == 3) {
                        board[r][c] = -1; //-1 for was dead but will be alive
                    }
                }
            }
        }
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c ++) {
                if (board[r][c] == 2) board[r][c] = 0;
                else if (board[r][c] == -1) board[r][c] = 1;
            }
        }
    }

    private int countNeighbors(int[][] board, int r , int c) {
        int counts = 0;
        for (int[] dir : directions){
            int r_next = r+dir[0];
            int c_next = c+dir[1];
            if (r_next >= 0 && c_next >= 0 && r_next<board.length && 
            c_next <board[0].length && board[r_next][c_next] > 0) {
                counts ++;
            }
        }
        return counts;
    }
}
// @lc code=end

