package com.lc.q40;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 剑指 Offer 05
 */

public class Q40 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.replaceSpace("     "));
    }
}

class Solution {
    public String replaceSpace(String s) {
        StringBuilder res = new StringBuilder();
        for(Character c : s.toCharArray())
        {
            if(c == ' ') res.append("%20");
            else res.append(c);
        }
        return res.toString();
    }
}

