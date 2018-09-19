package com.zhangzhen.case02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 用户在控制台输入字符回显，不会出现乱码
 * @author zhangzhen
 * @since 2018-09-18
 */
public class ConsoleEcho {

    public void echo() {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(System.in, "UTF-8");
            BufferedReader br = new BufferedReader(inputStreamReader);
            System.out.println("the echo programing started, please type something in the console!");
            String str = br.readLine();
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
