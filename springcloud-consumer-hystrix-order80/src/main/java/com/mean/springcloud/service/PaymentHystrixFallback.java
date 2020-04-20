package com.mean.springcloud.service;

import org.springframework.stereotype.Component;

/***
 *  @Author :  ZhengJia
 *  Date:  2020/4/20
 *  Time: 20:56
 *  Description:
 **/
@Component
public class PaymentHystrixFallback implements PaymentHystrixService {
    @Override
    public String getPaymentOk() {
        return "PaymentHystrixFallback getPaymentOk o(╥﹏╥)o";
    }

    @Override
    public String getPaymentTimeout() {
        return "PaymentHystrixFallback getPaymentTimeout o(╥﹏╥)o";
    }
}
