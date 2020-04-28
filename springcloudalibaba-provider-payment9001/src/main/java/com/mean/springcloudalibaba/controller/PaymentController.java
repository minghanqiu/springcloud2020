package com.mean.springcloudalibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 *  @Author :  ZhengJia
 *  Date:  2020/4/25
 *  Time: 11:22
 *  Description:
 **/
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/payment/nacos/{id}")
    public String get(@PathVariable("id") Long id){
        return "Nacos 注册成功，本次注册端口号："+serverPort+"\t"+id;
    }
}
