package com.mean.springcloud.service.impl;

import com.mean.springcloud.service.IMessageSend;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/***
 *  @Author :  ZhengJia
 *  Date:  2020/4/24
 *  Time: 21:42
 *  Description:
 **/
@EnableBinding(Source.class)
public class MessageSend implements IMessageSend {
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("************* serial:"+serial);
        return null;
    }
}
