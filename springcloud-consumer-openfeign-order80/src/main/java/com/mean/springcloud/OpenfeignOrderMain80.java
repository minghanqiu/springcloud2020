package com.mean.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/***
 *  @Author :  ZhengJia
 *  Date:  2020/4/14
 *  Time: 20:46
 *  Description:
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class OpenfeignOrderMain80
{
    public static void main(String[] args) {
        SpringApplication.run(OpenfeignOrderMain80.class,args);
    }
}
