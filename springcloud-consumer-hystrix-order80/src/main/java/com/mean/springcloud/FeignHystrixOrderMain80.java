package com.mean.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/***
 *  @Author :  ZhengJia
 *  Date:  2020/4/19
 *  Time: 21:04
 *  Description:
 **/
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class FeignHystrixOrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignHystrixOrderMain80.class,args);
    }
}
