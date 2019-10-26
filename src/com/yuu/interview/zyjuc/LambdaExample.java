package com.yuu.interview.zyjuc;

/**
 * 1. 拷贝小括号，写死右箭头，落地大括号
 * 2. @FunctionalInterface
 * 3. default
 * 4. static
 * @author by Yuu
 * @Classname LambdaEmample
 * @Date 2019/10/24 22:28
 * @see com.yuu.interview.zyjuc
 */
public class LambdaExample {
    public static void main(String[] args) {
        /*Foo foo = () -> {
            System.out.println("Foo 说话");
        };
        foo.say();*/
        Foo foo = (int x, int y) -> {return x + y;};
        //System.out.println(foo.add(1, 2));
        //System.out.println(foo.mul(2, 3));
        //System.out.println(foo.div(6, 2));
        System.out.println(Foo.reduce(3, 1));
    }
}

@FunctionalInterface
interface Foo {
    // void say();
    int add(int x, int y);

    default int mul(int x, int y) {
        return x * y;
    }

    default int div(int x, int y) {
        return x / y;
    }

    static int reduce(int x, int y) {
        return x - y;
    }
}
