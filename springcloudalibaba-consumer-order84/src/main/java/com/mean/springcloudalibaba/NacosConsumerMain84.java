package com.mean.springcloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/***
 *  @Author :  ZhengJia
 *  Date:  2020/4/25
 *  Time: 11:21
 *  Description:
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConsumerMain84 {
    public static void main(String[] args) {
        SpringApplication.run(NacosConsumerMain84.class,args);
    }
}
