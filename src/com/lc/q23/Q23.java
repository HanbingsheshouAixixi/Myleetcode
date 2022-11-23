package com.lc.q23;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * 回溯法
 * 1.与顺序有关的  即顺序不同算不同的（如求各种全排列等）  用visited[]作标记  每次回溯遍历完整数组
 * 2.与顺序无关的  即顺序相同算同一种的（如求和为k 子集的） 每次回溯只遍历所取元素后方的数组
 */

public class Q23 {
}
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        backTrace(nums, new ArrayList<>(), res, 0);
        return res;
    }
    public void backTrace(int[] nums,List<Integer> curr, List<List<Integer>> res, int start){
        if(start >= nums.length){
            return;
        }
        for(int i = start; i < nums.length; i++){
            curr.add(nums[i]);
            res.add(new ArrayList<>(curr));
            backTrace(nums, curr, res, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}