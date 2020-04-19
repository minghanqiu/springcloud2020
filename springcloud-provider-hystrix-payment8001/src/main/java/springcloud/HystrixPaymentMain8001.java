package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/***
 *  @Author :  ZhengJia
 *  Date:  2020/4/13
 *  Time: 20:53
 *  Description:
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableCircuitBreaker
public class HystrixPaymentMain8001
{
    public static void main(String[] args) {
        SpringApplication.run(HystrixPaymentMain8001.class,args);
    }
}
