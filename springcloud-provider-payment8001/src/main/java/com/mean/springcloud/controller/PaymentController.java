package com.mean.springcloud.controller;

import com.mean.springcloud.entities.CommonResult;
import com.mean.springcloud.entities.Payment;
import com.mean.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/***
 *  @Author :  ZhengJia
 *  Date:  2020/4/13
 *  Time: 21:15
 *  Description:
 **/
@RestController
@Slf4j
public class PaymentController
{
    @Resource
    PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(Payment payment)
    {
        int result = paymentService.create(payment);
        log.info("********插入结果：" + result);
        if (result > 0)
        {
            return new CommonResult(200,"创建成功",result);
        }else
        {
            return new CommonResult(444,"创建失败",payment);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id)
    {
        Payment payment = paymentService.getPaymentById(id);
        log.info("********查询结果：" + payment);
        if (payment != null)
        {
            return new CommonResult(200,"查询成功",payment);
        }else
        {
            return new CommonResult(444,"查询失败,Id:"+id,null);
        }
    }
}