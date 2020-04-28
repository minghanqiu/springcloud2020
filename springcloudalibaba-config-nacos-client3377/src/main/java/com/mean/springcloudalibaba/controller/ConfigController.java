package com.mean.springcloudalibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 *  @Author :  ZhengJia
 *  Date:  2020/4/25
 *  Time: 14:19
 *  Description:
 **/
@RestController
@Slf4j
@RefreshScope
public class ConfigController {
    @Value("${config.info}")
    private String configInfo;


    @GetMapping(value = "/getConfigInfo")
    public String getConfigInfo(){
        return configInfo;
    }
}
