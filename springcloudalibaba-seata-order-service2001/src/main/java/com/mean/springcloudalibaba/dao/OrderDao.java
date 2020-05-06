package com.mean.springcloudalibaba.dao;

import com.mean.springcloudalibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/***
 *  @Author :  ZhengJia
 *  Date:  2020/5/6
 *  Time: 22:45
 *  Description:
 **/
@Mapper
public interface OrderDao {
    //1 新建订单
    void createOrder(Order order);

    //2 修改订单状态 从0改为1
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
