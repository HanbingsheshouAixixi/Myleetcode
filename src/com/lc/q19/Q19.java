package com.lc.q19;

import java.util.HashMap;

/**
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 *
 * 滑动窗口新应用
 */

public class Q19 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abba"));
    }
}
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        HashMap<Character,Integer> mp = new HashMap<>();//记录right指针之前  每种元素最后一次出现时的下标
        char[] c = s.toCharArray();
        int left = -1;
        int right = 0;
        int res = 0;

        while(right < c.length){
            if(mp.containsKey(c[right])){
                left = Math.max(left,mp.get(c[right]));//如果left - right之间存在目前right所指的元素，则把left指向该元素
            }
            res = Math.max(res, right - left);//两重复元素间距离+1 等于子串长度
            mp.put(c[right], right);//更新记录
            right++;
        }
        return res;
    }
}