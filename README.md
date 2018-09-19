# ant-interview

> 本项目采用 `maven` 构建，请使用 `jdk1.8` 编译运行

## 题目

### 题目01

```java
提供一个懒汉模式的单实例类实现。
要求：
1.考虑线程安全。
2.基于junit提供测试代码，模拟并发，测试线程安全性，给出对应的断言。
```
```java
答题：/src/main/java/com/zhangzhen/case01/Singleton.java

测试：/src/test/java/com/zhangzhen/case01/SingletonTest.java
```

### 题目02

```java
题目：用户在控制台输入字符回显。
要求：
1.在控制台输入字符串，按回车后，要求控制台可以回显该字符串，如运行JAVA程序后，在控制台输入"test"回车后，控制台可以回显test。
2.限定使用JAVA中 io包下面类来处理，不允许使用java.util 中的 scan方法处理。
3.代码编写时，考虑使用JAVA提供的带缓冲的IO工具，提升代码运行效率。
4.输入字符串可以包括中文， 该代码可支持在不同操作系统下运行，避免出现乱码。
```
```java
答题：/src/main/java/com/zhangzhen/case02/ConsoleEcho.java

测试：/src/test/java/com/zhangzhen/case02/ConsoleEchoTest.java
```
### 题目03

```java
题目：
1.设计含最小函数min()、取出元素函数pop()、放入元素函数push()的栈AntMinStack，实现其中指定的方法
2.AntMinStack中数据存储使用Java原生的Stack，存储数据元素为int
```
```java
答题：/src/main/java/com/zhangzhen/case03/AntMinStack.java

测试：/src/test/java/com/zhangzhen/case03/AntMinStackTest.java
```

### 题目04

```java
设计数据结构与算法，计算算数表达式，需要支持
基本计算，加减乘除，满足计算优先级 例如输入 3*0+3+8+9*1 输出20
括号，支持括号，例如输入 3+（3-0）*2 输出 9
假设所有的数字均为整数，无需考虑精度问题
要求：
1.输入的表达式是字符串类型String。
2.对于操作数要求不止一位，这里对字符串里面解析出操作数有要求，需要有从表达式里面解析出完整操作数的能力。
3.代码结构要求具备一定的面向对象原则，能够定义出表达式，操作数，运算符等对象。
```
```java
答题：
/src/main/java/com/zhangzhen/case04/Calculator.java
/src/main/java/com/zhangzhen/case04/Expression.java
/src/main/java/com/zhangzhen/case04/Operator.java

测试：/src/test/java/com/zhangzhen/case04/CalculatorTest.java
```
