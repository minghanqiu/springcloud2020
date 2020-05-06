package com.mean.springcloudalibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/***
 *  @Author :  ZhengJia
 *  Date:  2020/5/6
 *  Time: 22:45
 *  Description:
 **/
@Mapper
public interface AccountDao {

    /**
     * 扣减账户余额
     * @param userId
     * @param money
     */
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}