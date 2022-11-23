package com.lc.q45;
/**
 * 139. 单词拆分
 * 动态规划
 * dp[i] 代表字符串0-i的子串是否可以由字典中元素构成
 * dp[i]为true有两种条件可以达成：
 * 1. 子串0-i出现在字典中
 * 2.dp[j]为true且子串j+1~i存在于字典中
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Q45 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<String> strings = new ArrayList<>();
        strings.add("leet");
        strings.add("code");

        System.out.println(solution.wordBreak("leetcode", strings));
    }
}

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        HashSet<String> hm = new HashSet<>(wordDict);//用hashset提高搜索效率
        if (hm.contains(s.substring(0, 1))) dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[j] == true && hm.contains(s.substring(j + 1, i + 1))) {
                    dp[i] = true;//代表以此为结尾的子串是否可由字典中的元素构成
                }
            }
            if (hm.contains(s.substring(0, i + 1))) dp[i] = true;
        }
        return dp[s.length() - 1];
    }
}