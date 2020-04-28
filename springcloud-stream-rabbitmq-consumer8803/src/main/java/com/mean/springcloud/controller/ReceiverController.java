package com.mean.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/***
 *  @Author :  ZhengJia
 *  Date:  2020/4/24
 *  Time: 20:58
 *  Description:
 **/
@Component
@EnableBinding(Sink.class)
public class ReceiverController {
    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("接受者2号，收到消息："+message.getPayload()+"\t"+"port:"+serverPort);
    }
}
