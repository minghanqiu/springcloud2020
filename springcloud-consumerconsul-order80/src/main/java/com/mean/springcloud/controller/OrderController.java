package com.mean.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.UUID;

/***
 *  @Author :  ZhengJia
 *  Date:  2020/4/18
 *  Time: 20:33
 *  Description:
 **/
@RestController
@Slf4j
public class OrderController {
    private static final String PAYMENT_URL = "http://consul-provider-payment";
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/payment/consul")
    public String payment(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/consul",String.class);
    }
}
