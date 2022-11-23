package com.lc.q17;


import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 任何数和 00 做异或运算，结果仍然是原来的数，即 a \oplus 0=aa⊕0=a。
 * 任何数和其自身做异或运算，结果是 00，即 a \oplus a=0a⊕a=0。
 * 异或运算满足交换律和结合律，即 a \oplus b \oplus a=b \oplus a \oplus a=b \oplus (a \oplus a)=b \oplus0=ba⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b。
 *
 * 作者：LeetCode-Solution
 * 链接：https://leetcode.cn/problems/single-number/solution/zhi-chu-xian-yi-ci-de-shu-zi-by-leetcode-solution/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * 线性时间复杂度  考虑异或
 */

public class Q17 {
    public static void main(String[] args) {
        int[] test = {4,2,1,2,1};
        Solution solution = new Solution();
        System.out.println(solution.singleNumber(test));
    }
}
class Solution {
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}

