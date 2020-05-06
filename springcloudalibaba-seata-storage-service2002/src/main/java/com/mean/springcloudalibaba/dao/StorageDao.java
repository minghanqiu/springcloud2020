package com.mean.springcloudalibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/***
 *  @Author :  ZhengJia
 *  Date:  2020/5/6
 *  Time: 22:45
 *  Description:
 **/
@Mapper
public interface StorageDao {
    /**
     * 减库存
     * @param productId
     * @param count
     * @return
     */
    int decrease(@Param("productId") Long productId, @Param("count") Integer count);
}