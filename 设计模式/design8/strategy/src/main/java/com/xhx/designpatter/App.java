package com.xhx.designpatter;

/**
 * xuhaixing
 * 2018/6/18 18:19
 **/
public class App {
    public static void main(String[] args) {
        //具体执行哪个策略由外部环境决定，这里可以融合工厂模式
        //Context context = new Context(new MD5Strategy());
        Context context = new Context(new MDSStrategy());
        context.encrypt();
    }
}
