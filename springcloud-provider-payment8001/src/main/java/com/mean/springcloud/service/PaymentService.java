package com.mean.springcloud.service;

import com.mean.springcloud.dao.PaymentDao;
import com.mean.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

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
