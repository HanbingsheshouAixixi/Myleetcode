package com.lc.q31;

/**
 * 165. 比较版本号
 */
public class Q31 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.compareVersion("0.1", "1.1");
    }
}

class Solution {
    public int compareVersion(String version1, String version2) {
        String[] splitedVersion1 = version1.split("\\.");
        String[] splitedVersion2 = version2.split("\\.");
        int length1 = splitedVersion1.length;
        int length2 = splitedVersion2.length;
        for (int i = 0; i < Math.min(length1, length2); i++) {
            int num1 = Integer.parseInt(splitedVersion1[i]);
            int num2 = Integer.parseInt(splitedVersion2[i]);
            if (num1 < num2) return -1;
            if (num1 > num2) return 1;
        }
        if (length1 > length2) {
            for (int i = length2; i < length1; i++) {
                if (Integer.parseInt(splitedVersion1[i]) != 0)
                    return 1;
            }
            return 0;
        } else if (length1 < length2) {
            for (int i = length1; i < length2; i++) {
                if (Integer.parseInt(splitedVersion2[i]) != 0)
                    return -1;
            }
            return 0;
        } else
            return 0;
    }
}
