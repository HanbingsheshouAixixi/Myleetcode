package com.lc.q46;

/**
 * 581.最短无序连续子数组
 * 数组有序  具体到每一个元素为其大于等于前面所有元素  小于等于后面所有元素
 * 从左往右找最后一个错误值
 * 从右往左找最后一个错误值
 * 两个错误值中间的序列都需要改
 *
 * @return
 **/

public class Q46 {
}

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length == 1) return 0;
        int high = 0;
        int low = nums.length - 1;
        int localMax = nums[0];
        int localMin = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < localMax) {
                high = i;
            } else {
                localMax = nums[i];
            }
        }
        for (int j = nums.length - 2; j >= 0; j--) {
            if (nums[j] > localMin) {
                low = j;
            } else {
                localMin = nums[j];
            }
        }
        if (low > high) {
            return 0;
        } else {
            return high - low + 1;
        }

    }
}