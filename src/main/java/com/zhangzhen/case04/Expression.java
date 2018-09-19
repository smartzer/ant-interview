package com.zhangzhen.case04;

import java.util.Stack;

/**
 * 表达式
 *
 * @author zhangzhen
 * @since 2018-09-19
 */
public class Expression {

    private static final String EMPTY_STRING = "";

    // 中缀表达式
    private String fixExpression;

    // 后缀表达式
    private StringBuilder postfixExpression;

    // 操作栈
    private Stack<Character> stack;

    public Expression(String fixExpression) {
        // 替换空格，中文括号
        this.fixExpression = fixExpression.replace(" ", "").replace("（", "(").replace("）", ")");
        postfixExpression = new StringBuilder(EMPTY_STRING);
        stack = new Stack<>();
    }

    public String getPostfixExpression() {
        // 转换表达式
        changeFixExpressionToPostfixExpression();
        return postfixExpression.toString();
    }

    /**
     * 将中缀变换为后缀
     */
    private void changeFixExpressionToPostfixExpression() {
        postfixExpression = new StringBuilder(EMPTY_STRING);
        char c;
        for (int i = 0; i < fixExpression.length(); i++) {
            c = fixExpression.charAt(i);
            // 数字字符，继续读取
            if (Character.isDigit(c)) {
                postfixExpression.append(c);
            }
            // 运算符，分支判断，将运算符压栈
            else {
                char top;
                if (stack.size() == 0) {
                    stack.push(c);
                    continue;
                }
                switch (c) {
                    case Operator.CHAR_ADD:
                    case Operator.CHAR_SUBTRACT:
                        top = stack.peek();
                        if (top == Operator.CHAR_MULTIPLY || top == Operator.CHAR_DIVIDE) {
                            postfixExpression.append(stack.pop());
                            stack.push(c);
                        } else {
                            stack.push(c);
                        }
                        break;
                    case Operator.CHAR_MULTIPLY:
                    case Operator.CHAR_DIVIDE:
                        top = stack.peek();
                        if (top == Operator.CHAR_MULTIPLY || top == Operator.CHAR_DIVIDE) {
                            postfixExpression.append(stack.pop());
                            stack.push(c);
                        } else {
                            stack.push(c);
                        }
                        break;
                    case Operator.CHAR_LEFT_BRACKET:
                        stack.push(c);
                        break;
                    case Operator.CHAR_RIGHT_BRACKET:
                        top = stack.pop();
                        while (top != Operator.CHAR_LEFT_BRACKET) {
                            postfixExpression.append(top);
                            top = stack.pop();
                        }
                        break;
                }
            }
        }
        // 将栈内剩余的数字或字符弹栈，加到表达式末尾
        while (stack.size() != 0) {
            postfixExpression.append(stack.pop());
        }
    }
}
