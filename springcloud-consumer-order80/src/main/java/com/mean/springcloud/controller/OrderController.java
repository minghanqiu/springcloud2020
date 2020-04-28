package com.mean.springcloud.controller;

import cn.hutool.core.util.ObjectUtil;
import com.mean.springcloud.entities.CommonResult;
import com.mean.springcloud.entities.Payment;
import com.mean.springcloud.rule.LoadBalancer;
import com.mean.springcloud.rule.impl.MyLB;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/***
 *  @Author :  ZhengJia
 *  Date:  2020/4/14
 *  Time: 20:47
 *  Description:
 **/
@RestController
@Slf4j
public class OrderController
{
    private static final String PAYMENT_URL = "http://springcloud-payment-service";
    @Autowired
    RestTemplate restTemplate;
    @Resource
    private DiscoveryClient discoveryClient;
    @Resource
    private LoadBalancer loadBalancer;

    @GetMapping(value = "/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment)
    {
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id)
    {
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getForEntity(@PathVariable("id") Long id)
    {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()){
            log.info("*****statusCode:"+entity.getStatusCode());
            log.info("*****header:"+entity.getHeaders());
            return entity.getBody();
        }else {
            return new CommonResult<>(444,"操作失败");
        }
    }

    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentlb()
    {
        List<ServiceInstance> instances = discoveryClient.getInstances("springcloud-payment-service");
        if (ObjectUtil.isEmpty(instances)){
            return null;
        }else {
            ServiceInstance choose = loadBalancer.choose(instances);
            URI uri = choose.getUri();
            log.info(choose.getUri().toString());
            log.info(choose.getServiceId());
            String url = choose.getServiceId();
//            return restTemplate.getForObject(uri+"/payment/lb/",String.class);
            return restTemplate.getForObject("http://"+url+"/payment/lb/",String.class);
        }

    }

    @GetMapping(value = "/consumer/payment/zipkin")
    public String paymentZipkin(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/zipkin/",String.class);
    }
}
