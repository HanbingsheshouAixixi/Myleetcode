package com.lc.q25;

/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 中心扩散法
 */

public class Q25 {
}
class Solution {
    public String longestPalindrome(String s) {
        char[] c = s.toCharArray();
        int longest = 1;
        int answerStart = 0;
        int left;
        int right;
        for(int i = 0; i < c.length; i++){
            left = i;
            right = i;
            while(true){
                if(left - 1 > 0 && c[left - 1] == c[i]){
                    left--;
                }else{
                    break;
                }
            }
            while(true){
                if(right + 1 < c.length && c[right + 1] == c[i]){
                    /**
                     * 先找出相邻两边与之相等的元素并用左右指针标记到最边界  才能不漏掉类似于1221的情况
                     */
                    right++;
                }else{
                    break;
                }
            }
            while(true){
                left--;
                right++;
                if(left < 0 || right == c.length){
                    break;
                }
                if(c[left] != c[right]){
                    break;
                }
            }
            left++;
            right--;
            if(right - left + 1 > longest){
                longest = right - left + 1;
                answerStart = left;
            }
        }
        return s.substring(answerStart, answerStart + longest);
    }
}