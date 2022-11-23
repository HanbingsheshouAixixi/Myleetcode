package com.lc.q20;

/**
 * 链表的插入排序
 *
 */

public class Q20 {
}

class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode resPre = new ListNode(0);
        resPre.next = head;
        ListNode lastSorted = head;//已排序序列的末尾
        ListNode current = head.next;//待排序列总在已排序列后一位
        ListNode search;

        while (current != null) {
            if (current.val >= lastSorted.val) {//待排序列有序  直接往后看
                current = current.next;
                lastSorted = lastSorted.next;
            } else {//无序，在前方序列中寻找插入位置
                search = resPre;
                while (search.next.val < current.val) {//找第一个比它大的 插到前面
                    search = search.next;
                }
                lastSorted.next = current.next;//取出待排元素！！！！！！！！！！！！！！！！！
                current.next = search.next;
                search.next = current;//插入
                current = lastSorted.next;//标记新待排元素
            }
        }
        return resPre.next;
    }
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

