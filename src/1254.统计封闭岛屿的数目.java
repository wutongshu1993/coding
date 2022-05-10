/*
 * @lc app=leetcode.cn id=1254 lang=java
 *
 * [1254] 统计封闭岛屿的数目
 */

// @lc code=start
class Solution {
    public int closedIsland(int[][] grid) {
        // 将最上、最下、最左、最右 淹掉
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
                if(grid[i][j]==0){
                    res++;
                    dfs(grid, i, j);
                }
            }
           
        }
        return res;
    }
    public void dfs(int[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        if(i<0 || j <0 || i>=m || j>= n){
            return;
        }
        if(grid[i][j]==1){
            return;
        }
        grid[i][j]=1;
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);

    }
}
// @lc code=end

