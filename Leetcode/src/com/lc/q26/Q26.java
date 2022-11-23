package com.lc.q26;

/**
 * 剑指 Offer 12. 矩阵中的路径
 * 回溯+dfs
 * 来到一个点  若符合序列则打标记并向可以走的方向继续深度遍历
 */

public class Q26 {
    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        Solution solution = new Solution();
        solution.exist(board, "ABCCED");
    }
}

class Solution {
    boolean flag = false;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        int[][] mark = new int[board.length][board[0].length];
        char[] words = word.toCharArray();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, words, 0, i, j, mark);
                /**
                 * 传入函数下一步要往哪里走！
                 */
            }
        }
        return flag;
    }

    public void dfs(char[][] board, char[] words, int start, int m, int n, int[][] mark) {
        if (start >= words.length) {
            flag = true;
            return;
        }
        if (board[m][n] == words[start]) {
            if (start == words.length - 1) flag = true;
            mark[m][n] = 1;
            if (n + 1 < board[0].length && mark[m][n + 1] == 0) {
                dfs(board, words, start + 1, m, n + 1, mark);
            }
            if (n - 1 >= 0 && mark[m][n - 1] == 0) {
                dfs(board, words, start + 1, m, n - 1, mark);
            }
            if (m + 1 < board.length && mark[m + 1][n] == 0) {
                dfs(board, words, start + 1, m + 1, n, mark);
            }
            if (m - 1 >= 0 && mark[m - 1][n] == 0) {
                dfs(board, words, start + 1, m - 1, n, mark);
            }
            mark[m][n] = 0;
        }
    }


}