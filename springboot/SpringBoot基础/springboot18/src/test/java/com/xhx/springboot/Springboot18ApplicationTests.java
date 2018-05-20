package com.xhx.springboot;

import com.xhx.springboot.service.TaskSevice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot18ApplicationTests {


	@Autowired
	private TaskSevice taskSevice;

	/**
	 * 要等主线程完了，子线程再结束
	 * @throws Exception
	 */
	@Test
	public void testTask() throws Exception{
		CountDownLatch countDownLatch = new CountDownLatch(2);
		taskSevice.executeAsyncTask1(countDownLatch);
		taskSevice.executeAsyncTask2(countDownLatch);

		System.out.println("主线程执行完了");
		countDownLatch.await();
		System.out.println("等待完毕");
	}
}
