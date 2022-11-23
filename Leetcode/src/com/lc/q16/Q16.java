package com.lc.q16;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 回溯法 DFS
 * 判断依据是左右括号剩余的数量
 */

public class Q16 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> strings = solution.generateParenthesis(5);
        for (String str: strings
             ) {
            System.out.println(str);
        }
    }
}
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs("", n, n, res);
        return res;
    }

    public void dfs(String tmp, int left, int right, List<String> res){
        if(left == 0 && right == 0){
            res.add(tmp);
        }
        if(left > right || left < 0 || right < 0) return;
        dfs(tmp + "(", left - 1, right, res);
        if(left < right){
            dfs(tmp + ")", left, right - 1, res);
        }
    }
}
