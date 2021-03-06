package org.white.springtest.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.exception.HystrixBadRequestException;
import org.springframework.stereotype.Service;
import org.white.springtest.exception.MyHystrixException;
import org.white.springtest.service.HelloService;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p></p >
 *
 * @author white
 * @version $Id: HelloServiceImpl.java, v 0.1 2019年01月17日 14:57:00 white Exp$
 */
@Service("helloService")
public class HelloServiceImpl implements HelloService {

    private AtomicInteger successAtomicInteger = new AtomicInteger();
    private AtomicInteger failAtomicInteger = new AtomicInteger();

    @Override
    @HystrixCommand(
            fallbackMethod = "testHelloFallback",
            threadPoolKey = "sayHello",
            commandKey = "sayHello"
//            threadPoolProperties = {
//                    @HystrixProperty(name = "coreSize", value = "10"),
//                    @HystrixProperty(name = "maxQueueSize", value = "100"),
//                    @HystrixProperty(name = "queueSizeRejectionThreshold", value = "20")},
//            commandProperties = {
//                    //若干10s一个窗口内失败次数, 则达到触发熔断的最少请求量
//                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
//                    //错误比率阀值，如果错误率>=该值，circuit会被打开，并短路所有请求触发fallback。默认50
//                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
//                    //断路后尝试执行时间, 默认为5s
//                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
////                    @HystrixProperty(name = "fallback.enabled", value = "false")
//            }
            )
//    @CircuitAop(fallbackMethod = "testHelloFallback")
    public String sayHello(int i) {
        if (i <= 0) {
            throw new RuntimeException();
//            throw new MyHystrixException("execute exception", 1001);
        }
        return "hello：" + Thread.currentThread().getName();
    }

    @Override
    @HystrixCommand(
            fallbackMethod = "testRejectionFallback",
            threadPoolKey = "rejectionThread",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "10"),
                    @HystrixProperty(name = "maxQueueSize", value = "1000"),
//                    @HystrixProperty(name = "queueSizeRejectionThreshold", value = "100")
            },
            commandProperties = {
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "80"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
//                    @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "100")
            })
    public String testRejection() {
        return "success：    " + successAtomicInteger.incrementAndGet();
    }

    @Override
    @HystrixCommand(
            fallbackMethod = "testTimeOutFallback",
            threadPoolKey = "sayHelloTimeOut",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "5"),
                    @HystrixProperty(name = "maxQueueSize", value = "10"),
                    @HystrixProperty(name = "queueSizeRejectionThreshold", value = "10")},
            commandProperties = {
                    //若干10s一个窗口内失败次数, 则达到触发熔断的最少请求量
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
                    //错误比率阀值，如果错误率>=该值，circuit会被打开，并短路所有请求触发fallback。默认50
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "80"),
                    //断路后尝试执行时间, 默认为5s
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "100000"),
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100")
            })
    public String sayHelloTimeOut(long i) throws InterruptedException {
        Thread.sleep(i);
        return "ddddd：" + Thread.currentThread().getName();
    }

    public String testHelloFallback(int i) {
        return "testHelloFallback executed：" + Thread.currentThread().getName();
    }

    public String testTimeOutFallback(long i) throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(1000);
        return "testTimeOutFallback execute：" + (System.currentTimeMillis() - begin);
    }

    public String testRejectionFallback() {
        return "fail：     " + failAtomicInteger.incrementAndGet();
    }

    public AtomicInteger getSuccessAtomicInteger() {
        return successAtomicInteger;
    }

    public AtomicInteger getFailAtomicInteger() {
        return failAtomicInteger;
    }
}
