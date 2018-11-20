package com.xhx.java.future;


import org.junit.Test;

/**
 * Future模式
 */
public class Test02 {

    @Test
    public void test01() {
        Client client = new Client();

        //这里会立即返回
        Data data = client.request("name");
        System.out.println("调用完毕");

        try {
            //这里代表处理其它业务逻辑
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("最终结果："+data.getResult());
    }
}


