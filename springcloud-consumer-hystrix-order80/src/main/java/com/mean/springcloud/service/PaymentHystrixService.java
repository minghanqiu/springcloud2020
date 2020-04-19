package com.mean.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/***
 *  @Author :  ZhengJia
 *  Date:  2020/4/19
 *  Time: 21:07
 *  Description:
 **/
@Component
@FeignClient(value = "SPRINGCLOUD-PROVIDER-HYSTRIX-PAYMENT")
public interface PaymentHystrixService {

    @GetMapping(value = "/payment/hystrix/OK")
    public String getPaymentOk();

    @GetMapping(value = "/payment/hystrix/timeout")
    public String getPaymentTimeout();
}
