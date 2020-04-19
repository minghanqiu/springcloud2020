package com.mean.springcloud.rule;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/***
 *  @Author :  ZhengJia
 *  Date:  2020/4/18
 *  Time: 21:27
 *  Description:
 **/
public interface LoadBalancer {
    ServiceInstance choose(List<ServiceInstance> serviceInstanceList);
    Integer getAndIncrement();
}
