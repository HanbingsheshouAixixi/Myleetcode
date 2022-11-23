package com.lc.q36;

/**
 * 287. 寻找重复数
 *
 * 整数数组  元素大小在长度范围内的话  可以考虑将其视为链表操作 相等的元素值是同意节点  元素值为结点的next指针
 */

public class Q36 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = {1, 3, 4, 2, 2};
        int duplicate = solution.findDuplicate(test);
        System.out.println(duplicate);
    }
}

class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        int count = 0;

        while (true) {
            slow = nums[slow];
            fast = nums[fast];
            fast = nums[fast];
            count++;
            if(nums[fast] == nums[slow]){
                break;
            }
        }
        slow = 0;
        fast = 0;
        for (int i = 0; i < count; i++) {
            fast = nums[fast];
        }
        while (nums[fast] != nums[slow]) {
            /*
            数组中的元素不仅作为了链表的指针，还是结点的唯一标识，因此当判断用整形变量表示的指针是否指向同一结点时，要判断数组元素值，而不是仅判断下标
             */
            slow = nums[slow];
            fast = nums[fast];
        }
        return nums[slow];

    }
}