package org.white.springtest.service.impl;

import org.springframework.stereotype.Service;
import org.white.springtest.aop.CircuitAop;
import org.white.springtest.service.HelloService;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

/**
 * <p></p >
 *
 * @author white
 * @version $Id: HelloServiceImpl.java, v 0.1 2019年01月17日 14:57:00 white Exp$
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Override
    @HystrixCommand(
            fallbackMethod = "testHelloFallback",
            threadPoolKey = "sayHello",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "10"),
                    @HystrixProperty(name = "maxQueueSize", value = "100"),
                    @HystrixProperty(name = "queueSizeRejectionThreshold", value = "20")},
            commandProperties = {
                    //若干10s一个窗口内失败次数, 则达到触发熔断的最少请求量
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
                    //错误比率阀值，如果错误率>=该值，circuit会被打开，并短路所有请求触发fallback。默认50
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "80"),
                    //断路后尝试执行时间, 默认为5s
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000")
            })
//    @CircuitAop(fallbackMethod = "testHelloFallback")
    public String sayHello(int i) {
        if (i == 0) {
            throw new RuntimeException();
        }
        return "hello" + i;
    }

    @Override
    @HystrixCommand(
            fallbackMethod = "testHelloFallback",
            threadPoolKey = "sayHelloTimeOut",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "10"),
                    @HystrixProperty(name = "maxQueueSize", value = "100"),
                    @HystrixProperty(name = "queueSizeRejectionThreshold", value = "20")},
            commandProperties = {
                    //若干10s一个窗口内失败次数, 则达到触发熔断的最少请求量
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
                    //错误比率阀值，如果错误率>=该值，circuit会被打开，并短路所有请求触发fallback。默认50
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "80"),
                    //断路后尝试执行时间, 默认为5s
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000")
            })
    public String sayHelloTimeOut(int i) throws InterruptedException {
        Thread.sleep(i);
        return "ddddd";
    }

    public String testHelloFallback(int i) {
        return "testHelloFallback execute";
    }
}
