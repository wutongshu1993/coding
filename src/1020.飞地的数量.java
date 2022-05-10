/*
 * @lc app=leetcode.cn id=1020 lang=java
 *
 * [1020] 飞地的数量
 */

// @lc code=start
class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for(int j = 0; j < n; j++){
            dfs(grid, 0, j);
            dfs(grid, m-1, j);
        }
        for(int i = 0; i < m; i++){
            dfs(grid, i, 0);
            dfs(grid, i, n-1);
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j]==1){
                    res += dfs(grid, i, j);
                }
                
            }
        }
        return res;
    }
    public int dfs(int[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        if(i<0 || j <0 || i>=m || j>= n){
            return 0;
        }
        if(grid[i][j]==0){
            return 0;
        }
        grid[i][j] = 0;
        return 1 + dfs(grid, i-1, j)+dfs(grid, i+1, j)+dfs(grid, i, j-1)+dfs(grid, i, j+1);

    }
}
// @lc code=end

