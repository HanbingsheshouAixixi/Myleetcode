package com.lc.q7;

import java.util.Arrays;
/*
最小覆盖子串
求最短子串，基本要：
if：窗口不满足  right往右；
if：窗口满足 left往右；

若找子串的排列 则窗口大小不变 元素出现次数相等
若只需覆盖子串 则窗口大小变化 目标窗口中元素个数大于等于标准窗口中元素个数
 */

public class Q7 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }
}

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        int min = Integer.MAX_VALUE;
        int start = 0;
        int left = 0;
        int right = t.length() - 1;

        int[] markT = new int['z' - 'A' + 1];
        int[] window = new int['z' - 'A' + 1];

        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();

        for (int i = 0; i < t.length(); i++) {
            markT[tt[i] - 'A']++;//标准窗口
        }

        for (int i = 0; i < t.length(); i++) {
            if (markT[ss[i] - 'A'] != 0) {
                window[ss[i] - 'A']++;
            }
        }

        while (right < s.length()) {
            if (comp(markT, window)) {//符合标准窗口
                if (right - left + 1 < min) {
                    min = right - left + 1;
                    start = left;
                }
                //左移左指针
                if (markT[ss[left] - 'A'] != 0) {
                    //t中包含该元素
                    window[ss[left] - 'A']--;
                }
                left++;
            } else {//不符合
                right++;
                if (right == s.length()) break;
                if (markT[ss[right] - 'A'] != 0) {
                    window[ss[right] - 'A']++;
                }
            }
        }
        if (min == Integer.MAX_VALUE) {
            return "";
        } else {
            return s.substring(start, start + min);
        }
    }

    public static boolean comp(int[] markT, int[] window) {
        for (int i = 0; i < markT.length; i++) {
            if (window[i] < markT[i])
                return false;
        }
        return true;
    }
}
