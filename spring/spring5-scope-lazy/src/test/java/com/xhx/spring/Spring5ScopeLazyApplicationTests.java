package com.xhx.spring;

import com.xhx.spring.config.ScopeConfig;
import com.xhx.spring.domain.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Spring5ScopeLazyApplicationTests {

    @Test
    public void testScope() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ScopeConfig.class);
        Person bean = annotationConfigApplicationContext.getBean(Person.class);
        System.out.println(bean);
        Person bean2 = annotationConfigApplicationContext.getBean(Person.class);
        System.out.println(bean2);

    }

}
