package com.lc.q30;

/**
 * 300. 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * 动态规划
 * dp[i]记录以下标为i的元素结尾的子序列的长度最大值  到达i+1时
 * 遍历0~i  从其中元素值小于nums[i + 1]的集合中选dp最大值m
 * 将dp[i + 1]置为m + 1
 */

public class Q30 {
    public static void main(String[] args) {
        int[] test = {4, 10, 4, 3, 8, 9};
        Solution solution = new Solution();
        solution.lengthOfLIS(test);
    }
}
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for(int i = 1; i < nums.length; i++){
            int maxTemp = 0;
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    maxTemp = Math.max(maxTemp, dp[j]);
                }
            }
            maxTemp++;
            dp[i] = maxTemp;
        }
        int res = 0;
        for(int i = 0; i < dp.length; i++){
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}