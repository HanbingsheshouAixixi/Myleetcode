package com.lc.q35;

public class Q35 {
    public static void main(String[] args) {
        int[][] test = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        Solution solution = new Solution();
        int i = solution.maxAreaOfIsland(test);
        System.out.println(i);
    }
}

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, dfs(grid, j, i));
                }
            }
        }
        return res;
    }

    public int dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid[0].length || y < 0 || y >= grid.length || grid[y][x] == 2 || grid[y][x] == 0) {
            return 0;
        }
        grid[y][x] = 2;
        int[] around = new int[4];
        around[0] = dfs(grid, x, y - 1);
        around[1] = dfs(grid, x, y + 1);
        around[2] = dfs(grid, x - 1, y);
        around[3] = dfs(grid, x + 1, y);
        int aroundSum = 0;
        for (int i = 0; i < 4; i++) {
            aroundSum += around[i];
        }
        return aroundSum+ 1;
    }
}
