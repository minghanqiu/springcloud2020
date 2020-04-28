package com.mean.springcloudalibaba.controller;

import com.mean.springcloud.entities.CommonResult;
import com.mean.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/***
 *  @Author :  ZhengJia
 *  Date:  2020/4/27
 *  Time: 22:22
 *  Description:
 **/
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap = new HashMap<>();
    static {
        hashMap.put(1L,new Payment(1L,"123123123123123"));
        hashMap.put(2L,new Payment(2L,"234234234234234"));
        hashMap.put(3L,new Payment(3L,"345353453453453"));
        hashMap.put(4L,new Payment(4L,"456856876867886"));
    }

    @RequestMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
        Payment payment = hashMap.get(id);
        CommonResult<Payment> result = new CommonResult<>(200,"from sql ,serverPort:"+serverPort,payment);
        return result;
    }
}
