package com.lc.q15;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * 回溯问题 DFS
 * 求所有可行方案或所有满足要求的组合时常用这种方法
 * 在叶节点判断触底 并添加答案
 */

public class Q15 {
}

class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[nums.length];
        backtrack(res, nums, new ArrayList<Integer>(), visited);
        return res;

    }

    private void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> tmp, int[] visited) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) continue;
            visited[i] = 1;//标记在本轮用过的元素
            tmp.add(nums[i]);//将本轮用过的元素加入生成序列
            backtrack(res, nums, tmp, visited);//按以上两条信息做该结点以下的遍历
            visited[i] = 0;//退出该结点前，将本轮做的标记擦除
            tmp.remove(tmp.size() - 1);
        }
    }
}
