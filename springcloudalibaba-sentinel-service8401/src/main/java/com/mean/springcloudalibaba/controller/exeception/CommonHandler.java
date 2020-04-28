package com.mean.springcloudalibaba.controller.exeception;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/***
 *  @Author :  ZhengJia
 *  Date:  2020/4/27
 *  Time: 22:00
 *  Description:
 **/
public class CommonHandler {

    public static String commonHandler(BlockException blockEeception){
        return "Global handler";
    }
}
