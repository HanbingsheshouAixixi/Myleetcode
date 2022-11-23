package com.lc.q24;

/**
 * 53. 最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 *
 *
 * 动态规划
 *
 * 指针遍历到某元素  若其前一元素大于0，则该元素加上前一元素，反之保持不变
 * 原理：这样的话 遍历过后每个元素的位置上存放的都是以该处元素为末尾的连续子串的最大和。
 */

public class Q24 {
}
class Solution {
    public int maxSubArray(int[] nums) {
        for(int i = 1; i < nums.length; i++){
            if(nums[i - 1] < 0){
                /**
                 * 前方子串和为负数  将此元素并入形成的子串肯定没有此元素单独成串 子串和的值大  故此元素单独成串
                 */
                continue;
            }else{
                nums[i] += nums[i - 1];
                /**
                 * 前方子串和为正数  将此元素并入后形成的子串和的值更大 因此选择并入
                 */
            }
        }
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > res){
                res = nums[i];
            }
        }
        return res;
    }
}
