package com.mean.springcloudalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.mean.springcloud.entities.CommonResult;
import com.mean.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/***
 *  @Author :  ZhengJia
 *  Date:  2020/4/25
 *  Time: 11:22
 *  Description:
 **/
@RestController
public class OrderController {
    @Value("${service-url.nacos-user-service}")
    private String serviceUrl;
    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/paymentSQL/{id}")
    @SentinelResource(value = "paymentSQL" ,blockHandler = "fallbackHandler")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        CommonResult result = restTemplate.getForObject(serviceUrl + "/paymentSQL/" + id, CommonResult.class);
        if (id == 4){
            throw new IllegalArgumentException("非法参数异常");
        }else if (result.getData() == null){
            throw new NullPointerException("空指针异常");
        }
        return result;
    }

    public String fallbackHandler(Long id, BlockException exception){
        return "This is my house";
    }
}
