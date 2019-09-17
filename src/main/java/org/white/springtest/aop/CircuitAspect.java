package org.white.springtest.aop;

import javafx.util.Pair;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.white.springtest.circuit.CircuitContext;
import org.white.springtest.model.enums.CircuitStatusEnum;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p></p >
 *
 * @author white
 * @version $Id: CircuitAspect.java, v 0.1 2019年05月14日 11:39:00 white Exp$
 */
@Aspect
@Component
public class CircuitAspect {

    private CircuitContext circuitContext = new CircuitContext();

    /**
     * 简易熔断流程
     * 1:判断是否打开熔断,打开则直接返回指定信息
     * 2:执行逻辑,成功失败都进行标记 markSuccess markFail
     */
    @Around("@annotation(circuitAop)")
    public Object doCircuit(ProceedingJoinPoint point, CircuitAop circuitAop) throws Throwable {
        String methodName = point.getSignature().getName();
        if (!circuitContext.canRequest(methodName)) {
            String fallbackMethodName = circuitAop.fallbackMethod();
            Method fallbackMethod = Arrays.stream(point.getTarget().getClass().getDeclaredMethods())
                    .filter(m -> m.getName().equals(fallbackMethodName)).findFirst().orElse(null);
            Assert.notNull(fallbackMethod, "fallbackMethod can not be null");
            return fallbackMethod.invoke(point.getTarget(), point.getArgs());
        }
        try {
            Object result = point.proceed();
            circuitContext.markSuccess(methodName);
            return result;
        } catch (Exception e) {
            circuitContext.markFail(methodName);
            throw e;
        }
    }
}
