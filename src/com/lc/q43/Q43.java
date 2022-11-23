package com.lc.q43;

import java.util.Stack;

public class Q43 {
}

class CQueue {

    private Stack<Integer> stackMain = new Stack<>();
    private Stack<Integer> stackSup = new Stack<>();

    public CQueue() {
    }

    public void appendTail(int value) {
        while (!stackMain.isEmpty()) {
            stackSup.push(stackMain.pop());
        }
        stackMain.push(value);
        while(!stackSup.isEmpty()){
            stackMain.push(stackMain.pop());
        }
    }

    public int deleteHead() {
        if (stackMain.isEmpty()) return -1;
        return stackMain.pop();
    }
}