package com.mean.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***
 *  @Author :  ZhengJia
 *  Date:  2020/4/19
 *  Time: 15:24
 *  Description:
 **/
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
