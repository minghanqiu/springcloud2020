package com.mean.springcloud.service;

import com.mean.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/***
 *  @Author :  ZhengJia
 *  Date:  2020/4/13
 *  Time: 21:12
 *  Description:
 **/
public interface PaymentService
{
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
