package com.mean.springcloud.service.impl;

import com.mean.springcloud.dao.PaymentDao;
import com.mean.springcloud.entities.Payment;
import com.mean.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/***
 *  @Author :  ZhengJia
 *  Date:  2020/4/13
 *  Time: 21:13
 *  Description:
 **/
@Service
public class PaymentServiceImpl implements PaymentService
{
    @Resource
    PaymentDao paymentDao;

    public int create(Payment payment)
    {
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id)
    {
        return paymentDao.getPaymentById(id);
    }
}
