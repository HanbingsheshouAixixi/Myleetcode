package com.lc.q28;

public class Q28 {
    public static void main(String[] args) {
        int[] nums = {-1, 2, 0};
        Solution solution = new Solution();
        solution.findKthLargest(nums, 2);
    }
}

class Solution {
    int res;

    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 1) return nums[0];
        qucikSearch(nums, nums.length - k, 0, nums.length - 1);
        return nums[res];
    }

    public void qucikSearch(int[] nums, int k, int left, int right) {
        if (left <= right) {
            int pivotop = paritition(nums, left, right);
            if (pivotop > k) {
                qucikSearch(nums, k, left, pivotop - 1);
            } else if (pivotop < k) {
                qucikSearch(nums, k, pivotop + 1, right);
            } else {
                res = pivotop;
            }
        }
    }

    public int paritition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) right--;
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) left++;
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }
}