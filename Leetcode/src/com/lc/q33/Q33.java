package com.lc.q33;

public class Q33 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] test = {{'1','0','1','1','0','1','1'}};
        solution.numIslands(test);
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[j][i] == '1'){
                    dfs(grid, j, i);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int x, int y){
        if(0 <= x && x < grid[0].length && 0 <= y && y < grid.length){
            if(grid[y][x] != '1'){
                return;
            }
            grid[y][x] = '2';
            dfs(grid, x, y + 1);
            dfs(grid, x, y - 1);
            dfs(grid, x + 1, y);
            dfs(grid, x - 1, y);
        }
    }
}