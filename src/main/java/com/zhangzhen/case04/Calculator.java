package com.zhangzhen.case04;

import java.util.*;

/**
 * 计算器 支持基本计算，加减乘除，满足计算优先级，支持整数
 *
 * @author zhangzhen
 * @since 2018-09-19
 */
public class Calculator {

    private String expression;

    private Stack<Integer> stack;

    public Calculator(String expression) {
        this.expression = expression;
        stack = new Stack<>();
    }

    /**
     * 计算表达式结果
     *
     * @return 返回运算结果
     */
    public int calculate() {
        int retVal;
        try {
            for (int i = 0; i < expression.length(); i++) {
                char ch = expression.charAt(i);
                if (Character.isDigit(ch)) {
                    stack.push(ch - 48);
                } else {
                    // 从栈中获取操作数
                    int secondNum = stack.pop();
                    int firstNum = stack.pop();
                    // 根据不同运算符计算结果
                    switch (ch) {
                        case Operator.CHAR_ADD:
                            stack.push(firstNum + secondNum);
                            break;
                        case Operator.CHAR_SUBTRACT:
                            stack.push(firstNum - secondNum);
                            break;
                        case Operator.CHAR_MULTIPLY:
                            stack.push(firstNum * secondNum);
                            break;
                        case Operator.CHAR_DIVIDE:
                            stack.push(firstNum / secondNum);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 弹出结果值
            retVal = stack.pop();
        }
        return retVal;
    }
}
