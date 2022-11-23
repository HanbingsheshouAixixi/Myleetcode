package com.lc.q44;

/**
 * 221. 最大正方形
 * 以i,j处为右下角的正方形，其最大边长为其左，上，左上的正方形最大边长的最小值+1
 */

public class Q44 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] test = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(solution.maximalSquare(test));
    }
}

class Solution {
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int res = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            dp[0][i] = Integer.parseInt(matrix[0][i] + "");
            if (dp[0][i] == 1) res = 1;
        }
        for (int i = 0; i < matrix.length; i++) {
            dp[i][0] = Integer.parseInt(matrix[i][0] + "");
            if (dp[i][0] == 1) res = 1;
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]),
                            dp[i - 1][j - 1]) + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res * res;
    }
}