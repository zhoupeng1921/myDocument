package com.xhx.spring.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 自定义注解
 */

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.FIELD,ElementType.LOCAL_VARIABLE,ElementType.PARAMETER})
@Constraint(validatedBy = IsMobileValidate.class)
public @interface IsMobile {
    //在 ValidationMessages.properties 文件获取
    String message() default "{constraint.mobile.require.message}";
    boolean required() default true;

    //这两个属性必须加，否则会报错
    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
