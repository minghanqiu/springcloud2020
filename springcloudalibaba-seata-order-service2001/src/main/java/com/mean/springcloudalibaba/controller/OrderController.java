package com.mean.springcloudalibaba.controller;

import com.mean.springcloudalibaba.domain.CommonResult;
import com.mean.springcloudalibaba.domain.Order;
import com.mean.springcloudalibaba.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/***
 *  @Author :  ZhengJia
 *  Date:  2020/5/6
 *  Time: 22:54
 *  Description:
 **/
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping(value = "/order/create")
    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}
