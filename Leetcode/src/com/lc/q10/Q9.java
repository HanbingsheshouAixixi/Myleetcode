package com.lc.q10;

import java.util.ArrayList;

/*
搜索旋转排列数组
区分前后半段的办法： 在上升序列中，且元素值>nums[0]是前半段 <是后半段
 */
public class Q9 {
}

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (mid < nums.length - 1 && nums[mid + 1] > nums[mid] && nums[mid] >= nums[0]) {
                left = mid + 1;
            } else if (mid == nums.length - 1 || (nums[mid + 1] > nums[mid] && nums[mid] <= nums[0])) {
                right = mid - 1;
            } else {
                break;
            }
        }
        if (target >= nums[0]) {
            return splitSearch(nums, 0, mid, target);
        } else {
            return splitSearch(nums, mid + 1, nums.length - 1, target);
        }
    }

    public static int splitSearch(int[] nums, int left, int right, int target) {
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}