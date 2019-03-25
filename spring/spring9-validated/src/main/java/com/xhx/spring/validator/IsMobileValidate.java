package com.xhx.spring.validator;

import com.xhx.spring.utils.ValidatorUtil;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsMobileValidate implements ConstraintValidator<IsMobile, String> {
   private boolean required = true;

   @Override
   public void initialize(IsMobile constraint) {
      this.required = constraint.required();
   }

   @Override
   public boolean isValid(String value, ConstraintValidatorContext context) {
     if(required){
        return ValidatorUtil.isMobile(value);
     }else {
        if(!StringUtils.isEmpty(value)){
           return ValidatorUtil.isMobile(value);
        }
     }
     return true;
   }
}
