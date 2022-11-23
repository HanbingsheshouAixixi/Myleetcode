package com.lc.q1;

/**
 * 中心扩散法 test
 *
 */
public class Q1_01 {
    public static void main(String[] args) {
        System.out.println((new Solution01().longestPalindrome("babac")));
    }
}
class Solution01 {
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int longest = 0;
        String answer = null;
        String temp = null;

        for(int i = 0;i <length;i++){
            temp = check(chars, i, i, length, longest);
            if(temp != null) {
                answer = temp;
                longest = answer.length();
            }
            temp = check(chars, i, i + 1, length, longest);
            if(temp != null) {
                answer = temp;
                longest = answer.length();
            }
        }
        return answer;
    }

    public static String check(char[] chars, int left, int right, int length, int longest){
        int i = left;
        int j = right;
        while(i >= 0 && j < length){
            if(chars[i] == chars[j]){
                i --;
                j ++;
            }else{
                break;
            }
        }
            if(j - i - 1 > longest)
                return new String(chars, i + 1, j - i -1);
            else
                return null;
    }
}
