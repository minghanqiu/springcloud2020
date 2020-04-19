package com.mean.springcloud.controller;

import com.mean.springcloud.entities.CommonResult;
import com.mean.springcloud.entities.Payment;
import com.mean.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/***
 *  @Author :  ZhengJia
 *  Date:  2020/4/14
 *  Time: 20:47
 *  Description:
 **/
@RestController
@Slf4j
public class OpenfeignOrderController
{
    @Resource
    private PaymentFeignService paymentFeignClient;


    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id)
    {
        return paymentFeignClient.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/timeout")
    public String getPaymentTimeout()
    {
        return paymentFeignClient.getPaymentTimeout();
    }
}
