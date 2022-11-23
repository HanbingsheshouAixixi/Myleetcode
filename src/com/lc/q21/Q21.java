package com.lc.q21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. 组合总和
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
 *
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 *
 * 回溯法
 * 回溯算法关键在于:不合适就退回上一步
 * 然后通过约束条件, 减少时间复杂度.
 *
 * 找符合条件的子串常用滑动窗口
 * 找所有符合条件的组合方式常用回溯法
 */

public class Q21 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = {2, 3, 6, 7};
        System.out.println(solution.combinationSum(test, 7));
    }
}

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ori = new ArrayList<>();
        dfs(ori, candidates, target, res);
        return res;
    }
    public void dfs(List<Integer> ori, int[] candidates, int target, List<List<Integer>> res){
        if(candidates.length == 0 || target < 1){
            return;
        }
        for(int i = 0; i < candidates.length; i++){
            ori.add(candidates[i]);
            if(candidates[i] == target){
                List<Integer> ans = new ArrayList<>(ori);
                res.add(ans);
            }
            dfs(ori, Arrays.copyOfRange(candidates,i,candidates.length), target - candidates[i],res);
            ori.remove(ori.size() - 1);
        }
    }
}