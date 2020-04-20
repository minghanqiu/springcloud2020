package com.mean.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 *  @Author :  ZhengJia
 *  Date:  2020/4/21
 *  Time: 0:13
 *  Description:
 **/
@RestController
@Slf4j
public class ConfigClientController {

//    @Value("${config.info}")
//    private String configInfo;

    @Value("${config.info}")
    private String configInfo;  //要访问的3344上的信息

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo;
    }
}
