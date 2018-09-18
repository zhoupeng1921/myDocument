package com.xhx.spring.componentscan;

import com.xhx.spring.componentscan.config.MyConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ComponentScanApplicationTests {

    @Test
    public void testLoads() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        List<String> hello = Arrays.stream(context.getBeanDefinitionNames()).collect(Collectors.toList());
        hello.stream().filter(name->name.contains("hello")).peek(System.out::println).count();
    }

}
