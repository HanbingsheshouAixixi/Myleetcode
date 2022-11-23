package com.lc.q2;
/*
移除元素
经典双指针法
一个数组当两个用
 */
public class Q2 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};

        System.out.println((new Solution().removeElement(nums, 2)));
    }
}

class Solution {
    public int removeElement(int[] nums, int val) {
        int a = 0;
        int b = 0;
        int count = 0;
        while(b < nums.length){
            if(nums[b] != val){
                nums[a] = nums[b];
                a++;
                b++;
            }
            else{
                count ++;
                b++;
            }
        }
        return nums.length - count;
    }
}
