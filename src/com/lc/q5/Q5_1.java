package com.lc.q5;

import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/*
右指针向右运动试图满足包含最短超串，
一旦满足，左指针开始向右移动，试图剔除左侧的多余元素，
一旦不满足条件，右指针再开始运动
 */

public class Q5_1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7};
        int[] b = {1, 5, 9};

        int[] ints = solution.shortestSeq(a, b);
        System.out.println(ints);
    }
}

class Solution {

    public int[] shortestSeq(int[] big, int[] small) {
        if(big.length < small.length){
            int[] result = {};
            return result;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < small.length; i++) {
            map.put(small[i], 0);//初始化map，存短数组里的元素，数量为0
        }

        for (int i = 0; i < small.length; i++) {
            if (map.get(big[i]) != null) {
                map.put(big[i], map.get(big[i]) + 1);//记录初始窗口元素数量
            }
        }
        int left = 0;
        int right = left + small.length - 1;//标记初始窗口
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        boolean flag = true;


        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        while (right < big.length) {

            flag = true;//标志复位

            Iterator<Map.Entry<Integer, Integer>> iterator = entries.iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> entry = iterator.next();
                if (entry.getValue() < 1) {
                    flag = false;//不满足条件
                    break;
                }
            }
            if (flag) {//满足条件
                if (right - left + 1 < min) {
                    min = right - left + 1;
                    start = left;
                    end = right;
                }
                if (map.get(big[left]) != null) {//如果左指针所指元素在map内
                    map.put(big[left], map.get(big[left]) - 1);
                }
                left++;//左移
            } else {
                right++;
                if (right < big.length && map.get(big[right]) != null) {//不满足条件  右移
                    map.put(big[right], map.get(big[right]) + 1);
                }

            }
        }
        if (min == Integer.MAX_VALUE) {
            int[] result = {};
            return result;
        } else {
            int[] result = {start, end};
            return result;
        }
    }
}