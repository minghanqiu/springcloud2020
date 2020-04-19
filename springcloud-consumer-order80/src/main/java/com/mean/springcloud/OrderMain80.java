package com.mean.springcloud;

import com.mean.myrule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/***
 *  @Author :  ZhengJia
 *  Date:  2020/4/14
 *  Time: 20:46
 *  Description:
 **/
@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "springcloud-payment-service",configuration = MyRule.class)
public class OrderMain80
{
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }
}
