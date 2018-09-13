package com.xhx.springboot;

import com.xhx.springboot.enums.GenderEnum;
import org.junit.Test;

public class TestEnum {

    @Test
    public void testGenderEnum(){
        GenderEnum[] values = GenderEnum.values();
        System.out.println(values);
    }
}
