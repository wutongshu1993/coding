package treeNode.bst;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 * 96. 不同的二叉搜索树
 */
public class NumTrees {
    int[][] memo;
    public int numTrees(int n) {
        memo = new int[n][n];
        return nums(1, n);
    }

    public int nums(int start, int end) {
        if (start > end) {
            return 1;
        }
        if(memo[start][end] != 0){
            return memo[start][end];
        }
        int res = 0;
        for (int i = start; i <= end; i++) {
            res += nums(start, i - 1) * nums(i + 1, end);
        }
        memo[start][end] = res;
        return res;
    }
}
