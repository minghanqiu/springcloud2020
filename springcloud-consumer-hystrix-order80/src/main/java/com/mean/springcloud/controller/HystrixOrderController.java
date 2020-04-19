package com.mean.springcloud.controller;

import com.mean.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/***
 *  @Author :  ZhengJia
 *  Date:  2020/4/19
 *  Time: 21:09
 *  Description:
 **/
@RestController
@Slf4j
public class HystrixOrderController {
    @Resource
    private PaymentHystrixService paymentHystrixService;
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/consumer/payment/hystrix/OK")
    public String getPaymentOk() {
        List<String> services = discoveryClient.getServices();
        List<ServiceInstance> instances = discoveryClient.getInstances("SPRINGCLOUD-PROVIDER-HYSTRIX-PAYMENT");
        String result = paymentHystrixService.getPaymentOk();
        log.info(result);
        return result;
    }

    @GetMapping(value = "/consumer/payment/hystrix/timeout")
    public String getPaymentTimeout() {
        String result = paymentHystrixService.getPaymentTimeout();
        log.info(result);
        return result;
    }
}
