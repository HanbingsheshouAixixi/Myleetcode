package com.lc.q9;

public class Q9 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3,4,5,1};
        System.out.println(solution.peakIndexInMountainArray(arr));
    }
}

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int rigtht = arr.length - 1;
        int mid = 0;
        while (left <= rigtht) {
            mid = (left + rigtht) / 2;
            if (mid == 0 || (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1])) {
                left = mid + 1;
            } else if (mid == arr.length - 1 || (arr[mid] < arr[mid - 1] && arr[mid] > arr[mid + 1])) {
                rigtht = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
