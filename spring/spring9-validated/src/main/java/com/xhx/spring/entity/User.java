package com.xhx.spring.entity;

import com.xhx.spring.interfaces.New;
import com.xhx.spring.validator.IsMobile;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class User {

    @NotNull(groups = {New.class},message = "id不能为null")
    private Integer id;
    @NotEmpty
    private String name;
    private String address;

    @IsMobile
    private String mobile;

    @Pattern(regexp = "^[a-z0-9]+([._\\\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$ ",message = "邮箱格式错误")
    private String email;

}
