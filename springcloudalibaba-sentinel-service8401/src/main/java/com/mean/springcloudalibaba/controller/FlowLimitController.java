package com.mean.springcloudalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.mean.springcloudalibaba.controller.exeception.CommonFallback;
import com.mean.springcloudalibaba.controller.exeception.CommonHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/***
 *  @Author :  ZhengJia
 *  Date:  2020/4/26
 *  Time: 20:54
 *  Description:
 **/
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping(value = "/testA")
    public String testA(){
        log.info("*********testA");

        return "testA";
    }

    @GetMapping(value = "/testB")
    public String testB(){
        log.info("*********testB");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "testB";
    }
    @GetMapping(value = "/testC")
    public String testC(){
        log.info("*********testC");
        int age = 10/0;
        return "testC";
    }
    @GetMapping(value = "/testD")
    @SentinelResource(value = "testD" ,blockHandler = "handler",fallback = "")
    public String testD(@RequestParam(value = "p1",required = false)String p1, @RequestParam(value = "p2",required = false) String p2){
        log.info("*********testD");
        return "testD";
    }
    @GetMapping(value = "/testE")
    @SentinelResource(value = "testE"
            ,blockHandlerClass = CommonHandler.class,blockHandler = "commonHandler"
            ,exceptionsToIgnore = ArithmeticException.class
            ,fallbackClass = CommonFallback.class,fallback = "commonFallback"
    )
    public String testE(){
        log.info("*********testE");
        String string = null;
        if (string.equals("")){
            System.out.println(string);
        }
        int age = 10/0;
        return "testE";
    }

    public String fallback(){
        return "fallback________o(╥﹏╥)o";
    }

    public String handler( BlockException exe){
        return "handler_________o(╥﹏╥)o";
    }
}
