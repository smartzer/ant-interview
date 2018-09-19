package com.zhangzhen.case04;

import org.junit.Assert;
import org.junit.Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * 计算器测试
 *
 * @author zhangzhen
 * @since 2018-09-19
 */
public class CalculatorTest {

    // 使用 js 的 eval 验证
    private static final ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");

    @Test
    public void testCalculate() throws ScriptException {
        //String expr = "2*(3+2)-2*3";
        //String expr = "3 +（3-0）* 2";
        //String expr = "3*0+3+8+9*1";
        String expr = "5 + ((1 + 2) * 4)- 3";
        //String expr = "2+(3+2+1)*5";

        Expression expression = new Expression(expr);

        // 将中缀表达式转换成后缀表达式
        String postFixExpression = expression.getPostfixExpression();
        System.out.println(expr + " 转化成逆波兰表达式: " + postFixExpression);

        // 计算表达式的结果值
        Calculator calculator = new Calculator(postFixExpression);

        System.out.println(expr + " = " + calculator.calculate());

        //Assert.assertEquals(9, calculator.calculate());

        // eval 不能验证中文括号的表达式
        Assert.assertEquals(engine.eval(expr), calculator.calculate());
    }
}
