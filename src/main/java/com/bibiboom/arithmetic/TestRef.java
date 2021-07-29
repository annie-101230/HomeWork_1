package com.bibiboom.arithmetic;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.lang.reflect.Method;

/**
 * @author Annie
 * @date 2021年07月12日 15:40
 */

public class TestRef {

    public static void main(String[] args) throws Exception {

        final Foo foo = new Foo("这是一个实例对象!");
        final Class<? extends Foo> clazz = foo.getClass();
        final Method method1 = clazz.getDeclaredMethod("outInfo");
        final Method method2 = clazz.getDeclaredMethod("setMsg1", String.class);
        final Method method3 = clazz.getDeclaredMethod("getMsg");

        method1.invoke(foo);
        method2.invoke(foo, "手动篡改!");
        String msg = (String)method3.invoke(foo);
        System.out.println(msg);
        boolean flag = true;
        if (flag) {
            System.out.println("对哦");
        } else {
            System.out.println("不行");
        }
    }

}


class Foo{

    private String msg;
    private String msg1;

    public Foo(String msg) {
        this.msg = msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public void setMsg1(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void outInfo() {
        System.out.println("这是测试Java反射的测试类");
    }
}