package com.lc.q39;
/**
 * 56. 合并区间
 * 先排序
 * 分析区间之间可能存在的关系
 * 合并
 */

import java.util.Arrays;
import java.util.Comparator;

public class Q39 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] test = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge = solution.merge(test);
        for (int[] o : merge
        ) {
            for (int n:o
                 ) {
                System.out.print(n);
                System.out.println();
            }
        }
    }
}

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {//使用匿名内部类重写比较器 实现按头元素排序数组
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }//排序之后 后一组的头一定大于等于前一组的头
        });
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval : intervals) {
            if (idx == -1 || interval[0] > res[idx][1]) {
                res[++idx] = interval;
            } else {
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, idx + 1);//通过下标记录巧妙去除空值
    }
}
