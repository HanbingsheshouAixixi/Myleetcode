package com.lc.q38;

/**
 * 148. 排序链表
 * 不断将链表二等分然后再归并起来
 * 具体写出来则是：将该序列分为两段，分别排序，再归并起来。
 */

public class Q38 {
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }


        ListNode fast = head.next;//必须是head.next 不然的话后面会有死循环
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        /**
         * 这一段是归并时链表分段的固定写法，必须这样写，不然会栈溢出
         */

        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode res = new ListNode();
        ListNode mark = res;
        while (left != null && right != null) {
            if (left.val > right.val) {
                mark.next = right;
                mark = right;
                right = right.next;
            } else {
                mark.next = left;
                mark = left;
                left = left.next;
            }

        }
        if (left != null) mark.next = left;
        if (right != null) mark.next = right;
        return res.next;
    }
}
