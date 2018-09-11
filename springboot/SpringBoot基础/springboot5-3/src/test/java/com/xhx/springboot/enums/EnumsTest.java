package com.xhx.springboot.enums;

import org.junit.Test;

public class EnumsTest {

    @Test
    public void testConvert(){
        GenderEnum.convert convert = new GenderEnum.convert();
        String s = convert.convertToDatabaseColumn(GenderEnum.MAN);
        GenderEnum genderEnum = convert.convertToEntityAttribute(GenderEnum.WOMAN.getCode());
        System.out.println(s+"    "+genderEnum);
    }
}
