package com.mean.springcloud.rule.impl;

import com.mean.springcloud.rule.LoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/***
 *  @Author :  ZhengJia
 *  Date:  2020/4/18
 *  Time: 21:29
 *  Description:
 **/
@Component
public class MyLB implements LoadBalancer {
    private final AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public ServiceInstance choose(List<ServiceInstance> serviceInstanceList) {
        int index = getAndIncrement();
        index = index % serviceInstanceList.size();
        return serviceInstanceList.get(index);
    }

    @Override
    public Integer getAndIncrement() {
        int current = atomicInteger.get();
        int next;
        do {
            next = current >= 2147483647 ? 0 : current + 1;
        } while (!atomicInteger.compareAndSet(current, next));

        return next;
    }
}
