package com.mean.springcloud.controller;

import com.mean.springcloud.service.IMessageSend;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/***
 *  @Author :  ZhengJia
 *  Date:  2020/4/24
 *  Time: 21:44
 *  Description:
 **/
@RestController
@Slf4j
public class SendController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private IMessageSend messageSend;

    @GetMapping("/sendMessage")
    public String sendMessage(){
        return messageSend.send();
    }
}
