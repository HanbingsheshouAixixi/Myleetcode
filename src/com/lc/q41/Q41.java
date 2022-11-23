package com.lc.q41;

import java.util.Arrays;
import java.util.Stack;

public class Q41 {
    public static void main(String[] args) {

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> integers = new Stack<>();
        int count = 0;
        while(head != null){
            integers.push(head.val);
            head = head.next;
            count++;
        }
        int[] ints = new int[count];
        for (int i = 0; i < count; i++) {
            ints[i] = integers.pop();
        }
        return ints;
    }
}