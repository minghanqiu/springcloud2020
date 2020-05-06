package com.mean.springcloudalibaba.service.impl;

import com.mean.springcloudalibaba.dao.AccountDao;
import com.mean.springcloudalibaba.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/***
 *  @Author :  ZhengJia
 *  Date:  2020/5/6
 *  Time: 22:55
 *  Description:
 **/
@Service
public class AccountServiceImpl implements AccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Resource
    AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        LOGGER.info("------>account-service中扣减账户余额开始");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //模拟超时异常，全局事务回滚
        accountDao.decrease(userId,money);
        LOGGER.info("------>account-service中扣减账户余额结束");
    }
}