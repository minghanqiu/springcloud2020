package com.mean.springcloudalibaba.service;

import com.mean.springcloudalibaba.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/***
 *  @Author :  ZhengJia
 *  Date:  2020/5/6
 *  Time: 22:55
 *  Description:
 **/
public interface StorageService {
    /**
     * 扣减库存
     * @param productId
     * @param count
     */
    void decrease(Long productId,Integer count);
}