package com.mean.springcloud.controller;

import com.mean.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
public class HystrixPaymentController {

    @Value("${server.port}")
    private String serverPort;
    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/payment/hystrix/OK")
    public String getPaymentOk() {
        String result = paymentService.paymentInfo_OK();
        log.info(result);
        return result;
    }

    @GetMapping(value = "/payment/hystrix/timeout")
    public String getPaymentTimeout() {
        String result = paymentService.paymentInfo_Timeout();
        log.info(result);
        return result;
    }

    //服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("****result："+result);
        return result;
    }

}
