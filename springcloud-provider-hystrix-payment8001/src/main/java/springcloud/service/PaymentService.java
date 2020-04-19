package springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/***
 *  @Author :  ZhengJia
 *  Date:  2020/4/19
 *  Time: 15:43
 *  Description:
 **/
@Service
public class PaymentService {
    /**
     * 正常访问
     * @return
     */
    public String paymentInfo_OK(){
        return "线程池："+ Thread.currentThread().getName()+"\t"+"paymentInfo_OK,id:"+"\t"+"O(∩_∩)O哈哈~";
    }

    /**
     * 超时
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_Timeout(){
//        int timeout = 10/0;
        int timeout = 13;
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池："+ Thread.currentThread().getName()+"\t"+"paymentInfo_Timeout,id:"+"\t"+"O(∩_∩)O哈哈~"+"耗时(秒)："+timeout;
    }

    public String paymentInfo_TimeoutHandler(){
        return "线程池："+ Thread.currentThread().getName()+"\t"+"8001paymentInfo_TimeoutHandler,系统繁忙或运行出错:"+"\t"+"(#^.^#)";
    }
}
