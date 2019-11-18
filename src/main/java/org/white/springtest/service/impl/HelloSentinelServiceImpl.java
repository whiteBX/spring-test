package org.white.springtest.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.stereotype.Service;
import org.white.springtest.service.HelloService;

import java.util.ArrayList;
import java.util.List;

/**
 * <p></p >
 *
 * @author white
 * @version $Id: HelloSentinelServiceImpl.java, v 0.1 2019年11月15日 14:36:00 white Exp$
 */
@Service("helloSentinelService")
public class HelloSentinelServiceImpl implements HelloService {

    @Override
    @SentinelResource(value = "sayHello", fallback = "sayHelloFallBack")
    public String sayHello(int i) {
        if (i == 0) {
            throw new RuntimeException("");
        }
        return "hello world：" + Thread.currentThread().getName();
    }

    @Override
    @SentinelResource(value = "sayHelloTimeOut")
    public String sayHelloTimeOut(long i) throws InterruptedException {
        Thread.sleep(i);
        return "hello timeout：" + Thread.currentThread().getName();
    }

    @Override
    @SentinelResource("testRejection")
    public String testRejection() {
        return null;
    }

    public String sayHelloFallBack(int i) {
        return "sayHelloFallBack execute：" + Thread.currentThread().getName();
    }
}
