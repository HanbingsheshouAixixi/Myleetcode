package com.lc.q1;

/**
 * 最长回文子串
 * 暴力解法
 */
public class Q1 {//最长回文字符串  暴力解法
    public static void main(String[] args) {
        System.out.println(Solution.longestPalindrome("ccc"));
    }
}

class Solution {
    public static String longestPalindrome(String s) {
        byte[] bytes = s.getBytes();
        int longest = 0;
        String answer = new String(bytes, 0, 1);
        int mid = 0;
        int left = 0;
        int right = 0;

        for (int i = 0; i < bytes.length; i++)
            for (int j = i + 1; j < bytes.length; j++) {
                left = i;
                right = j;
                while (left <= right) {
                    if (bytes[left] == bytes[right]) {
                        left++;
                        right--;
                    } else
                        break;
                }
                if (left >= right && j - i + 1 > longest) {
                    answer = new String(bytes, i, j - i + 1);
                    longest = j - i + 1;
                }
            }
        return answer;

    }
}