package com.mean.springcloudalibaba.service.impl;

import com.mean.springcloudalibaba.dao.StorageDao;
import com.mean.springcloudalibaba.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/***
 *  @Author :  ZhengJia
 *  Date:  2020/5/6
 *  Time: 22:55
 *  Description:
 **/
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;

    /**
     * 减库存
     *
     * @param productId
     * @param count
     * @return
     */
    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------>account-service中扣减账户余额开始");
        //模拟超时异常，全局事务回滚
        storageDao.decrease(productId, count);
        log.info("------>account-service中扣减账户余额结束");
    }
}
