package org.white.springtest.service.impl;

import org.springframework.stereotype.Service;
import org.white.springtest.aop.LogAop;
import org.white.springtest.service.HelloService;

/**
 * <p></p >
 *
 * @author white
 * @version $Id: HelloServiceImpl.java, v 0.1 2019年01月17日 14:57:00 white Exp$
 */
@Service
@LogAop
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello() {
        System.out.println("hello ");
    }
}
