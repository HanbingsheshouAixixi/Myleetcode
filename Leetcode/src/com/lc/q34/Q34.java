package com.lc.q34;

public class Q34 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 2, 2, 2, 2};
        solution.findNumberOfLIS(nums);
    }
}

class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums.length == 1) return 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int[] count = new int[nums.length];
        count[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            count[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[i] == dp[j] + 1) {
                        count[i]++;
                    }
                }
            }
        }
        int maxLength = 1;
        int mark = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxLength) {
                maxLength = nums[i];
                mark = i;
            }
        }
        if (maxLength == 1) return nums.length;
        return count[mark];
    }
}
