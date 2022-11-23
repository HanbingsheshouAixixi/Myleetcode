package com.lc.q5;

import java.util.*;
/*
可以找出最短超串但不能总返回第一个符合的
 */

class Solution_ {

    public int[] shortestSeq(int[] big, int[] small) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < small.length; i++) {
            map.put(small[i], 0);
        }

        for (int i = 0; i < big.length; i++) {
            if (map.get(big[i]) != null) {
                map.put(big[i], map.get(big[i]) + 1);
            }
        }
        int left = 0;
        int right = big.length - 1;
        int flag = 0;

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        label:
        while (right - left + 1 >= small.length) {
            Iterator<Map.Entry<Integer, Integer>> iterator = entries.iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> entry = iterator.next();
                if (entry.getValue() == 0) {
                    flag = 2;
                    break label;
                }
            }
            if (map.get(big[left]) != null) {
                map.put(big[left], map.get(big[left]) - 1);
            }
            left++;

            iterator = entries.iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> entry = iterator.next();
                if (entry.getValue() == 0) {
                    flag = 1;
                    break label;
                }
            }
            if (map.get(big[right]) != null) {
                map.put(big[right], map.get(big[right]) - 1);
            }
            right--;
        }

        if (left == 0 && right == big.length - 1)
            return null;

        if (flag == 1) {
            int[] result = {left - 1, right};
            return result;
        } else {
            int[] result = {left, right + 1};
            return result;
        }

    }
}