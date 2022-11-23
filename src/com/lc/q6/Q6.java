package com.lc.q6;

import java.util.Arrays;

/*
Z字形变换  拿下
Arrays.copyOfRange取内容时区间是左闭右开的！ 注意！

 */
public class Q6 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convert("lzllovezxxxxxxxxxxxxxx", 2));
    }
}

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) return s;

        char[] c = s.toCharArray();
        char[] result = new char[c.length];

        int group = numRows * 2 - 2;//每组数量 必为偶数
        int groupNum = 0;
        if (c.length % group == 0) {
            groupNum = c.length / group;
        } else {
            groupNum = c.length / group + 1;
        }

        char[][] z = new char[groupNum][group];
        int left = 0;
        int rigtht = group - 1;

        for (int i = 0; i < groupNum - 1 && rigtht < c.length;
             i++, left = left + group, rigtht = rigtht + group) {
            z[i] = Arrays.copyOfRange(c, left, rigtht + 1);
        }


        for (int i = 0; i < group; i++, left++) {
            if (left < c.length) {
                z[groupNum - 1][i] = c[left];
            } else
                z[groupNum - 1][i] = '\u0000';
        }

        int mark = 0;
        for (int j = 0; j <= group / 2; j++) {
            for (int i = 0; i < groupNum; i++) {
                if (j == 0 || j == group / 2) {
                    if (z[i][j] != '\u0000') {
                        result[mark++] = z[i][j];
                    }
                } else {
                    if (z[i][j] != '\u0000') {
                        result[mark++] = z[i][j];
                    }
                    if (z[i][group - j] != '\u0000') {
                        result[mark++] = z[i][group - j];
                    }
                }
            }
        }
        return String.valueOf(result);

    }
}