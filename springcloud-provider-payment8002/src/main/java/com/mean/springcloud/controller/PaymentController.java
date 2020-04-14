package com.mean.springcloud.controller;

import com.mean.springcloud.entities.CommonResult;
import com.mean.springcloud.entities.Payment;
import com.mean.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/***
 *  @Author :  ZhengJia
 *  Date:  2020/4/13
 *  Time: 21:15
 *  Description:
 **/
@RestController
@Slf4j
public class PaymentController
{
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String  serverPort;


    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment)
    {
        int result = paymentService.create(payment);
        log.info("********插入结果：" + result);
        if (result > 0)
        {
            return new CommonResult(200,"创建成功,port:"+serverPort,result);
        }else
        {
            return new CommonResult(444,"创建失败,port:"+serverPort,payment);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id)
    {
        Payment payment = paymentService.getPaymentById(id);
        log.info("********查询结果：" + payment+"O(∩_∩)O哈哈~123");
        if (payment != null)
        {
            return new CommonResult(200,"查询成功,port:"+serverPort,payment);
        }else
        {
            return new CommonResult(444,"查询失败,Id:"+id,null);
        }
    }
}
