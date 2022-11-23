package com.lc.q13;

import java.util.HashMap;
/*
454. 四数相加 II
给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
0 <= i, j, k, l < n
nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0

前缀法的再次应用
先算出前两个数组的所有组合并加入hashmap
然后算出后两组的所有组合 去hashmap中寻找是否有相加和为0的元素
 */

public class Q13 {
}
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int length = nums1.length;
        int count = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int temp = 0;
        for(int i = 0; i < length; i++)
            for(int j = 0; j < length; j ++){
                temp = nums1[i] + nums2[j];
                hm.put(temp, hm.getOrDefault(temp, 0) + 1);
            }
        int temp2 = 0;
        for(int i = 0; i < length; i++)
            for(int j = 0; j < length; j ++){
                temp2 = nums3[i] + nums4[j];
                if(hm.containsKey(-temp2)){
                    count += hm.get(-temp2);
                }
            }
        return count;
    }
}