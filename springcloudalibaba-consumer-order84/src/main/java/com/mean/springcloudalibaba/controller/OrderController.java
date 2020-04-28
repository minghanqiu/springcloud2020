package com.mean.springcloudalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/***
 *  @Author :  ZhengJia
 *  Date:  2020/4/25
 *  Time: 11:22
 *  Description:
 **/
@RestController
public class OrderController {
    @Value("${service-url.nacos-user-service}")
    private String serviceUrl;
    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/paymentSQL/{id}")
    @SentinelResource(value = "paymentSQL")
    public String getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(serviceUrl + "/paymentSQL/" + id, String.class);
    }
}
