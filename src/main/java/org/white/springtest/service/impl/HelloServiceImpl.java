package org.white.springtest.service.impl;

import org.springframework.stereotype.Service;
import org.white.springtest.aop.CircuitAop;
import org.white.springtest.service.HelloService;

/**
 * <p></p >
 *
 * @author white
 * @version $Id: HelloServiceImpl.java, v 0.1 2019年01月17日 14:57:00 white Exp$
 */
@Service
@CircuitAop
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(int i) {
        if (i == 0) {
            throw new RuntimeException();
        }
        return "hello" + i;
    }
}
