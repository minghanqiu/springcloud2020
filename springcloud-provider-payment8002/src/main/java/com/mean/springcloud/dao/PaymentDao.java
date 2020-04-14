package com.mean.springcloud.dao;

import com.mean.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/***
 *  @Author :  ZhengJia
 *  Date:  2020/4/13
 *  Time: 20:57
 *  Description:
 **/
@Mapper
public interface PaymentDao
{
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
