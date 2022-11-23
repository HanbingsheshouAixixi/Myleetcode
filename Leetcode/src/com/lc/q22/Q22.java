package com.lc.q22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47.全排列II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 使所有相同元素进入序列时按照相同的顺序
 */

public class Q22 {
}
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int[] visited = new int[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        backTrace(nums, new ArrayList<>(), res, visited);
        return res;

    }
    public void backTrace(
            int nums[], List<Integer> curr, List<List<Integer>> res, int[] visited){
        if(curr.size() == nums.length){
            res.add(new ArrayList<>(curr));
        }
        for(int i = 0; i < nums.length; i++){
            if(visited[i] == 1 || i >= 1 && nums[i] == nums[i - 1] && visited[i - 1] != 1){
                /**
                 * 原数组经过排列后，相同元素相邻，因此在取元素时会被连续访问
                 * 取一个元素时若它前方有相同元素，则必须是其前方元素被访问过的情况下，才可访问此元素
                 * 这样可以保证相同元素进入序列的顺序是固定的
                 */
                continue;
            }
            curr.add(nums[i]);
            visited[i] = 1;
            backTrace(nums, curr, res, visited);
            visited[i] = 0;
            curr.remove(curr.size() - 1);
        }
    }
}
