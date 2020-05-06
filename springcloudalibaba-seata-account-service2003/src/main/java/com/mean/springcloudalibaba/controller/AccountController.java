package com.mean.springcloudalibaba.controller;

import com.mean.springcloudalibaba.domain.CommonResult;
import com.mean.springcloudalibaba.service.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/***
 *  @Author :  ZhengJia
 *  Date:  2020/5/6
 *  Time: 22:54
 *  Description:
 **/
@RestController
public class AccountController {

    @Resource
    AccountService accountService;

    @RequestMapping("/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money){
        accountService.decrease(userId,money);
        return new CommonResult(200,"扣减账户余额成功");
    }
}
