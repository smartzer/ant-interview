package com.zhangzhen.case03;

import java.util.Stack;

/**
 * 使用 jdk 原生 Stack 实现
 *
 * @author zhangzhen
 * @since 2018-09-18
 */
public class AntMinStack {

    /**
     * 实际栈数据
     */
    private Stack<Integer> stack;

    /**
     * 最小值栈数据
     */
    private Stack<Integer> minStack;

    public AntMinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    /**
     * push 放入元素
     *
     * @param data
     */
    public void push(int data) {
        stack.push(data);
        if (minStack.isEmpty()) {
            minStack.push(data);
        } else if (data <= minStack.peek()) {
            minStack.push(data);
        }
    }

    /**
     * pop 推出元素
     *
     * @return
     * @throws Exception
     */
    public int pop() throws Exception {
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        return stack.pop();
    }

    /**
     * min 最小函数，调用该函数，可直接返回当前AntMinStack的栈的最小值
     *
     * @return
     * @throws Exception
     */
    public int min() throws Exception {
        return minStack.peek();
    }
}
