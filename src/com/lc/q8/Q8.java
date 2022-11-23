package com.lc.q8;
/*
牛客 二维数组查找
注意数字大小变化规律
往上必减小
往右必增大
所以从左下角开始找
 */

public class Q8 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] test = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(solution.Find(1,test));
    }
}

class Solution {
    public boolean Find(int target, int [][] array) {
        int row = array.length - 1;
        int column = 0;
        while(row >= 0 && column < array[0].length){
            if(array[row][column] > target){
                row--;
            }else if(array[row][column] < target){
                column++;
            }else{
                return true;
            }
        }
        return false;
    }
}

