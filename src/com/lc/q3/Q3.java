package com.lc.q3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
三数之和
先排序 再双指针
排序的作用是使双指针有意义
 */

public class Q3 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {-1, 0, 1, 2, -1, -4};
        System.out.println(solution.threeSum(a));
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int i = 0;
        while (nums[i] <= 0 && i <= nums.length - 3) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                    while (nums[right] == nums[right + 1] && left < right) {
                        right--;
                    }
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                    while (nums[left] == nums[left - 1] && left < right) {
                        left++;
                    }
                } else {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    right--;
                    while (nums[right] == nums[right + 1] && left < right) {
                        right--;
                    }
                    left++;
                    while (nums[left] == nums[left - 1] && left < right) {
                        left++;
                    }
                }
            }
            i++;
            while (nums[i] == nums[i - 1] && nums[i] <= 0 && i <= nums.length - 3) {
                i++;
            }


        }
        return result;
    }
}