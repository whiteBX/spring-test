package org.white.springtest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * <p></p >
 *
 * @author white
 * @version $Id: LogAspect.java, v 0.1 2019年01月17日 14:25:00 white Exp$
 */
//@Component
@Aspect
public class LogAspect {

    @Around("@within(org.white.springtest.aop.LogAop)")
//    @Around("execution(* org.white.springtest.service.impl.HelloServiceImpl.*(..))")
    public Object doLog(ProceedingJoinPoint point) throws Throwable {
        System.out.println("11111111111111111111111111111111111111111111111111111");
        return point.proceed();
    }
}

