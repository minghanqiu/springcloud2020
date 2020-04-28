package com.mean.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/***
 *  @Author :  ZhengJia
 *  Date:  2020/4/24
 *  Time: 20:57
 *  Description:
 **/
@SpringBootApplication
@EnableEurekaClient
public class StreamMQConsumerMain8802 {
    public static void main(String[] args) {
        SpringApplication.run(StreamMQConsumerMain8802.class,args);
    }
}
