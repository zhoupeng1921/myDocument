package com.xhx.springboot.controller;

import com.xhx.springboot.entity.Account;
import com.xhx.springboot.exception.BusinessException;
import com.xhx.springboot.result.JsonResult;
import com.xhx.springboot.result.ReturnEnum;
import com.xhx.springboot.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author xuhaixing
 * @date 2018/5/2 9:55
 */
@RestController
@RequestMapping("account")
public class AccountController {
    private static  Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "findByName", method = RequestMethod.POST)
    public JsonResult<Account> findById(@RequestParam String name) throws Exception{

        logger.info("name="+name);
        if(name == null || name.equals("")){
            throw new BusinessException(ReturnEnum.error,new NullPointerException());
        }
        Account account = null;
        try {
            account = accountService.findByName(name);
        } catch (Exception e) {
            throw new BusinessException(e);
        }
        return JsonResult.success(account);
    }

}
