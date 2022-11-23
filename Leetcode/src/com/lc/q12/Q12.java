package com.lc.q12;

import java.util.HashMap;
/*
560. 和为 K 的子数组
给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。

不能用滑动窗口  因为有正有负  移动指针不知道是加是减
前缀法：
1.指针移动一位
2.计算出开始到现在的和pre
3.查看之前的序列中是否有和为pre - k的序列
4.有的话 count += 满足条件序列数
5.将pre对应的序列放入记录
 */

public class Q12 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,1,2};
        int k = 0;
        System.out.println(solution.subarraySum(nums, k));
    }
}

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();//存放各种和的序列的个数
        int count = 0;
        int work = 0;
        hm.put(0,1);//用于在 pre==k 时，帮助判断
        int pre = nums[0];
        while(true){
            if (hm.containsKey(pre - k)){
                count += hm.get(pre - k);
            }
            hm.put(pre, hm.getOrDefault(pre,0)+1);
            work++;
            if(work == nums.length) break;
            pre += nums[work];
        }
        return count;

    }
}