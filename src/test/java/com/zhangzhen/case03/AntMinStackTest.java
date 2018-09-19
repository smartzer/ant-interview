package com.zhangzhen.case03;

import org.junit.Assert;
import org.junit.Test;

/**
 * AntMinStackTest 测试
 *
 * @author zhangzhen
 * @since 2018-09-18
 */
public class AntMinStackTest {

    @Test
    public void testPushPop() throws Exception {
        AntMinStack stack = new AntMinStack();
        stack.push(8);
        stack.push(4);
        stack.push(3);
        stack.push(1);
        stack.push(10);
        stack.push(5);
        Assert.assertEquals(5, stack.pop());
        Assert.assertEquals(10, stack.pop());
        Assert.assertEquals(1, stack.min());
        Assert.assertEquals(1, stack.pop());
        Assert.assertEquals(3, stack.min());
        Assert.assertEquals(3, stack.pop());
        Assert.assertEquals(4, stack.pop());
        Assert.assertEquals(8, stack.pop());
    }
}
