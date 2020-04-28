package com.mean.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/***
 *  @Author :  ZhengJia
 *  Date:  2020/4/24
 *  Time: 21:41
 *  Description:
 **/
@SpringBootApplication
@EnableEurekaClient
public class StreamSendMain8801 {
    public static void main(String[] args) {
        SpringApplication.run(StreamSendMain8801.class,args);
    }
}
