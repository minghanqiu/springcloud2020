package com.mean.myrule;

import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***
 *  @Author :  ZhengJia
 *  Date:  2020/4/18
 *  Time: 21:19
 *  Description:
 **/
@Configuration
public class MyRule {

    @Bean
    public IRule MyRule(){
//        return new RandomRule();
//        return new RoundRobinRule();
        return new BestAvailableRule();
    }
}
