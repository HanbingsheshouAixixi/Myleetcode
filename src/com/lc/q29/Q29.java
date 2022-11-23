package com.lc.q29;

/**
 * 45. 跳跃游戏 II
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 假设你总是可以到达数组的最后一个位置。
 *
 * 跳跃游戏升级版
 * 由于要记录共跳了几次  所以把每一轮分开考虑 计算一步能到达的最大距离 记录步数  再以此距离为基础记录下一步的最大距离
 */

public class Q29 {
}
class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1) return 0;
        int k = 0;
        int currK = 0;
        int count = 0;
        while(true){
            currK = 0;
            for(int i = 0; i <= k; i++){
                currK = Math.max(currK, i + nums[i]);
            }
            count++;
            if(currK >= nums.length - 1){
                break;
            }
            k = Math.max(currK, k);
        }
        return count;
    }
}