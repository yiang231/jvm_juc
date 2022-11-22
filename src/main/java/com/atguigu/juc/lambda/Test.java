package com.atguigu.juc.lambda;

/**
 * lambda表达式口诀:
 *  复制小括号,写死右箭头,落地大括号
 */
public class Test {
    public static void main(String[] args) {
        //FooImpl foo = new FooImpl();
        //System.out.println(foo.add(1, 2));
        Foo foo = (int a,int b)->{
            return a+b;
        };
        System.out.println(foo.add(1, 2));
    }
}
