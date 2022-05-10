import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N 皇后
 */

// @lc code=start
class Solution51 {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        // 初始化棋盘
        String[][] board = new String[n][n];
        for(int i = 0; i < n; i++){
            for(int j= 0; j < n; j++){
                board[i][j] = ".";
            }
        }
        backtrack(board, 0);
        return res;
    }
    // 路径：board中，小于row的行已经被放置了皇后
    // 选择列表：row行所有列都是放置皇后的选择
    // 结束条件：row 超过board中的最后一行
    public void backtrack(String[][] board, int row){
        if(row == board.length){
            res.add(toList(board));
            return;
        }
    
        int colSize = board[0].length;
        for(int col = 0; col < colSize; col++){
            if(!isValid(board, row, col)){
                continue;
            }
            board[row][col]="Q";
            backtrack(board, row+1);
            board[row][col]=".";
        }
    }
    // 判断在第row行，第col列放置皇后可以吗
    public boolean isValid(String[][] board, int row, int col){
        // 同一列
        for(int i=0; i < row; i++){
           if(Objects.equals(board[i][col], "Q")){
            return false;
           }
        }
        // 左上
        int li = row-1, lj = col-1;
        for(; li >=0 && lj>=0; li--,lj--){
            if(Objects.equals(board[li][lj], "Q")){
                return false;
            }
        }
        // 左上
        int ri = row-1, rj=col+1;
        for(; ri >=0&& rj<board[0].length; ri--,rj++){
            if(Objects.equals(board[ri][rj], "Q")){
                return false;
            }
        }
        return true;
    }

    public ArrayList<String> toList(String[][] arr){
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            StringBuilder builder = new StringBuilder();
            for(int j = 0; j < arr.length; j++){
                builder.append(arr[i][j]);
            }
            list.add(builder.toString());
        }
        return list;
    }
}
// @lc code=end

