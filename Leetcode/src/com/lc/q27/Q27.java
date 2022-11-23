package com.lc.q27;

/**
 * 55. 跳跃游戏
 *
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 *
 * 每次更新可到底的最远距离
 * 具体方法是  最开始可到达的元素只有第一个  用i + nums[i] 计算出从此开始可到达的最远距离  在下一次循环时 对此范围内元素取可到达的最远距离
 * 此距离又作为下次循环的范围！
 */

public class Q27 {
}
class Solution {
    public boolean canJump(int[] nums) {
        int k = 0;//当前可到达的最远元素下标
        for(int i = 0; i <= k; i++){
            int tmp = i + nums[i];
            k = Math.max(k, tmp);

            if(k >= nums.length - 1){
                return true;
            }
        }
        return false;

    }
}