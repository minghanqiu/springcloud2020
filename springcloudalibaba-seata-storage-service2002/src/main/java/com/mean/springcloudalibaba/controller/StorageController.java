package com.mean.springcloudalibaba.controller;

import com.mean.springcloudalibaba.domain.CommonResult;
import com.mean.springcloudalibaba.service.StorageService;
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
public class StorageController {

    @Resource
    private StorageService storageService;

    @RequestMapping("/storage/decrease")
    public CommonResult decrease(Long productId, Integer count){
        storageService.decrease(productId,count);
        return new CommonResult(200,"扣减库存成功");
    }
}
