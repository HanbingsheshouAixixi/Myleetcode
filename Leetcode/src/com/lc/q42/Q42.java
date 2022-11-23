package com.lc.q42;


import java.util.Arrays;

public class Q42 {
    public static void main(String[] args) {
        int[] test1 = {3, 9, 20, 15, 7};
        int[] test2 = {9, 3, 15, 20, 7};
        Solution solution = new Solution();
        solution.buildTree(test1, test2);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        if (preorder.length == 1) return new TreeNode(preorder[0]);
        TreeNode res = new TreeNode(preorder[0]);
        int mid = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                mid = i;
                break;
            }
        }
        res.left = buildTree(Arrays.copyOfRange(preorder, 1, mid + 1),
                Arrays.copyOfRange(inorder, 0, mid));
        res.right = buildTree(Arrays.copyOfRange(preorder, mid + 1, preorder.length),
                Arrays.copyOfRange(inorder, mid + 1, inorder.length));
        return res;
    }
}