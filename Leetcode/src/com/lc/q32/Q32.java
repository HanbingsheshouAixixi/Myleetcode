package com.lc.q32;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 */

public class Q32 {
}
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[][] vidited = new int[matrix.length][matrix[0].length];
        List<Integer> res = new ArrayList<>();
        int x = 0;//横坐标
        int y = 0;//纵坐标
        vidited[0][0] = 1;
        res.add(matrix[0][0]);
        while(true){
            while(x + 1 < matrix[0].length && vidited[y][x + 1] ==0) {
                vidited[y][x + 1] = 1;
                x++;//右移
                res.add(matrix[y][x]);
            }
            while(y + 1 < matrix.length && vidited[y + 1][x] == 0) {
                vidited[y + 1][x] = 1;
                y++;//下移
                res.add(matrix[y][x]);
            }
            while(x - 1 >=0 && vidited[y][x - 1] == 0) {
                vidited[y][x - 1] = 1;
                x--;//左移
                res.add(matrix[y][x]);
            }
            while(y - 1 >=0 && vidited[y - 1][x] == 0) {
                vidited[y - 1][x] = 1;
                y--;//上移
                res.add(matrix[y][x]);
            }
            if((x - 1 < 0 || vidited[y][x - 1] == 1) &&
                    (x + 1 >= matrix[0].length || vidited[y][x + 1] == 1) &&
                    (y - 1 < 0 || vidited[y - 1][x] == 1) &&
                    (y + 1 >= matrix.length || vidited[y + 1][x] == 1)){
                break;
            }
        }
        return res;
    }
}
