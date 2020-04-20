package com.mean.springcloud.controller;

import com.mean.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/***
 *  @Author :  ZhengJia
 *  Date:  2020/4/19
 *  Time: 21:09
 *  Description:
 **/
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentInfoGlobalFallbackHandler")
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
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })
    @HystrixCommand
    public String paymentInfo_Timeout(){
        int age = 10/0;
        return paymentHystrixService.getPaymentTimeout();
    }

    public String paymentInfo_TimeoutHandler(){
        return "我是消费者80，对方支付系统繁忙请10秒钟后重试或者自己运行出错请检查自己o(╥﹏╥)o";
    }

    public String paymentInfoGlobalFallbackHandler(){
        return "Global异常处理信息，请稍后再试。o(╥﹏╥)o";
    }


}
